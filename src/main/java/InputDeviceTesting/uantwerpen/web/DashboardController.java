package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearchGroupRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

/**
 * Created by Niels on 6/11/2015.
 */
@Controller
public class DashboardController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ResearchGroupRepo researchGroupRepo;

    @ModelAttribute("allResearcherGroups")
    public List<ResearchGroup> populateResearcherGroups() {
        List<ResearchGroup> researchGroupList = researchGroupRepo.findAll();
        Collections.sort(researchGroupList);
        return researchGroupList;
    }

    @RequestMapping({"/","/home","/index"})
    public String goToDashboardpage(    ){
        return "redirect:/dashboard";
    }
    @RequestMapping("/dashboard")
    public String ShowDashboardPage(Principal principal){
        String researcherLogin = principal.getName();// get the username/email after login
        return "dashboard";
    }

    @RequestMapping(value = "/dashboard?sort=groupName", method = RequestMethod.GET)
    public String Sort(@RequestParam(value="name", required=false, defaultValue="World") String sort, Model model) {

        List<Researcher> researcherList = customUserDetailsService.findAll();
        Collections.sort(researcherList, Researcher.ResearcherNameComparator);
        model.addAttribute("allResearchers", researcherList);
        return "dashboard";
    }

}
