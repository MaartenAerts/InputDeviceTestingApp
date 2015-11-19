package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.repo.ResearchGroupRepo;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    private ResearchGroup researchGroup;

    private List<Researcher> researcherList;

    /*@ModelAttribute("Researchers")
    public List<Researcher> populateResearchers(Researcher researcher) {
        researcherList.add(researcher);
        return researcherList;
    }*/

    /*@ModelAttribute("Tests")
    public List<Test> populateTests(){
        List<Test> testList = testRepo.findAll();
        return testList;
    }*/

    @RequestMapping("/researchGroup")
    public String ShowResearchGroupPage(){
        researchGroup = new ResearchGroup();
        researcherList = new ArrayList<Researcher>();
        return "researchGroup";
    }

    @RequestMapping(value = "addResearcher", method = RequestMethod.POST)
    public String AddResearcher(@ModelAttribute("researcherForm") Researcher researcher, Model model) {

        model.addAttribute("Researchers",researcherList);

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
            }
        }

        return "researchGroup";
    }

    @RequestMapping(value = "saveGroup")
    public String saveGroup(@ModelAttribute("saveGroup") ResearchGroup researchGroup, Model model) {

        logger.info("Adding researchGroup");
        researchGroup.setCreatedDate(LocalDateTime.now());
        researchGroup.setModifiedDate(LocalDateTime.now());
        researchGroup.setResearcherList(researcherList);
        researchGroupRepo.save(researchGroup);
        return "dashboard";

    }

}
