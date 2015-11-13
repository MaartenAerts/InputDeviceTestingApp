package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**
 * Created by Niels on 13/11/2015.
 */
@Controller
public class ReasearcherController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @ModelAttribute("allResearchers")
    public List<Researcher> populateResearchers() {
        List<Researcher> researcherList = customUserDetailsService.findAll();
        return researcherList;
    }

    @RequestMapping("/researcherView")
    public String ShowDashboardPage(){return "researcherView";}

    @RequestMapping(value = "/researcherView?sort=firstname", method = RequestMethod.GET)
    public String Sort(@RequestParam(value="name", required=false, defaultValue="World") String sort, Model model) {

        List<Researcher> researcherList = customUserDetailsService.findAll();
        Collections.sort(researcherList, Researcher.ResearcherNameComparator);
        model.addAttribute("allResearchers", researcherList);
        return "researcherView";
    }

}
