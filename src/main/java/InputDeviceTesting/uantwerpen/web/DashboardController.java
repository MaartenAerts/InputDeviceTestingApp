package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * Created by Niels on 6/11/2015.
 */
@Controller
public class DashboardController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @ModelAttribute("allResearchers")
    public List<Researcher> populateResearchers() {return customUserDetailsService.findAll();
    }

    @RequestMapping({"/","/home","/index"})
    public String goToDashboardpage(){
        return "redirect:/dashboard";
    }
    @RequestMapping("/dashboard")
    public String ShowDashboardPage(){
        return "dashboard";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String Sort(Model model) {

        boolean test;
        test = model.containsAttribute("researcher");
        test = model.containsAttribute("allResearchers");

        List<Researcher> researcherList = customUserDetailsService.findAll();
        Collections.sort(researcherList, Researcher.ResearcherNameComparator);
        model.addAttribute("allResearchers", researcherList);
        return "dashboard";
    }

}
