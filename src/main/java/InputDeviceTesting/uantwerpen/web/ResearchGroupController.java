package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.repo.ResearchGroupRepo;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niels on 16/11/2015.
 */
@Controller
public class ResearchGroupController {

    private static final Logger logger = LoggerFactory.getLogger(ResearchGroupController.class);

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ResearcherRepo researcherRepo;

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private ResearchGroupRepo researchGroupRepo;

    private ResearchGroup globalResearchGroup;

    private List<Researcher> researcherList;

    private String globalGroupName;


    @ModelAttribute("allResearchers")
    public List<Researcher> populateResearchers() {
        List<Researcher> researcherList = customUserDetailsService.findAll();
        return researcherList;
    }

    @ModelAttribute("Tests")
    public List<Test> populateTests(){
        List<Test> testList = testRepo.findAll();
        return testList;
    }

    @RequestMapping("/researchGroup")
    public String ShowResearchGroupPage(@RequestParam(value="name", defaultValue="") String groupName, Model model){
        globalResearchGroup = null;
        researcherList = new ArrayList<Researcher>();
        globalGroupName = null;
    try {
        globalResearchGroup= researchGroupRepo.findByGroupName(groupName);
        researcherList = globalResearchGroup.getResearcherList();
        model.addAttribute("Researchers",researcherList);
        globalGroupName = globalResearchGroup.getGroupName();
        model.addAttribute("groupName",globalGroupName);
    }catch (Exception e){}

        return "researchGroup";
    }

    /*@RequestMapping("/researchGroup/{groupName}")
    public String ShowGroupNamePage(@PathVariable String groupName, Model model){
        globalResearchGroup= researchGroupRepo.findByGroupName(groupName);
        researcherList = globalResearchGroup.getResearcherList();
        model.addAttribute("Researchers",researcherList);
        globalGroupName = globalResearchGroup.getGroupName();
        model.addAttribute("groupName",globalGroupName);
        return "researchGroup";
    }*/

    @RequestMapping(value = "addResearcher", method = RequestMethod.POST)
    public String AddResearcher(@ModelAttribute("researcherForm") Researcher researcher, Model model) {

        model.addAttribute("Researchers",researcherList);
        model.addAttribute("groupName",globalGroupName);

        if(researcher.getEmail() != null && !researcher.getEmail().isEmpty()){
            logger.info("Adding researcher with email = " + researcher.getEmail());

            try{
                researcher = researcherRepo.findByEmail(researcher.getEmail());
                logger.info("A researcher with  email: " + researcher.getEmail() + "  exist | Status: OK!");
            }catch (NullPointerException  e){
                logger.error("Failed to retrieve researcher. Error = " + e);
                model.addAttribute("ResearcherExists","Email not found.");
                return "researchGroup";
            }
            //Whojo zotte equal shit enzuu.
            if(researcherList.contains(researcher) == false) {
                researcherList.add(researcher);
                model.addAttribute("Researchers",researcherList);
            }else {
                model.addAttribute("ResearcherExists","Email already added.");
            }
        }
        return "researchGroup";
    }

    @RequestMapping(value = "deleteResearcher", method = RequestMethod.POST)
    public String DeleteResearcher(@ModelAttribute("deleteForm") Researcher researcher, Model model) {

        researcherList.remove(researcher) ;// weer zotte shit enzuu
        model.addAttribute("Researchers",researcherList);
        model.addAttribute("groupName",globalGroupName);
        return "researchGroup";
    }

    @RequestMapping(value = "saveGroup", method = RequestMethod.POST)
    public String SaveGroup(@ModelAttribute("saveGroupForm") ResearchGroup researchGroup, Model model,Principal principal) {

        if (researchGroup.getGroupName() != "" && !researchGroup.getGroupName().isEmpty()) {
            ResearchGroup researchGroupForm = researchGroup;
            try{
                researchGroup = researchGroupRepo.findByGroupName(globalGroupName);
                researchGroup.setModifiedDate(LocalDateTime.now());
                researchGroup.setAmountOfResearchers(researcherList.size());
                researchGroup.setResearcherList(researcherList);
                researchGroupRepo.save(researchGroup);
                logger.info("A researchGroup with  Name: " + researchGroup.getGroupName() + "  exist | Status: OK!");
                return "redirect:/dashboard";
            }catch (NullPointerException  e){
                if (researchGroupRepo.findByGroupName(researchGroupForm.getGroupName()) != null){
                    logger.info("A group with name: " + researchGroupForm.getGroupName() + " already exist");
                    model.addAttribute("Error","Group Name already exists!");
                    model.addAttribute("Researchers",researcherList);
                    return "researchGroup";
                }
                String researcherLogin = principal.getName();// get the username/email after login
                logger.info("Adding researchGroup");
                researchGroupForm.setCreator(researcherRepo.findByEmail(researcherLogin));
                researchGroupForm.setCreatedDate(LocalDateTime.now());
                researchGroupForm.setModifiedDate(LocalDateTime.now());
                researchGroupForm.setAmountOfResearchers(researcherList.size());
                researchGroupForm.setResearcherList(researcherList);
                researchGroupRepo.save(researchGroupForm);
                return "redirect:/dashboard";
            }
        }
        model.addAttribute("groupName",globalGroupName);
        model.addAttribute("Error","Group Name is required!");
        return "researchGroup";
    }

    @RequestMapping(value = "deleteGroup")
    public String DeleteGroup(Model model){
        researchGroupRepo.delete(globalResearchGroup);
        return "redirect:/dashboard";
    }

}
