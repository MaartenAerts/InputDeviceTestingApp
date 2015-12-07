package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.model.TestResult;
import InputDeviceTesting.uantwerpen.model.createTest;
import InputDeviceTesting.uantwerpen.repo.CreateTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by TooLate on 5/11/2015.
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @Autowired
    CreateTestRepo createTestRepo;

    private createTest blub;


    @RequestMapping("test")//Todo:moet {id} worden
    public ModelAndView getTest(){
        return new ModelAndView("test");
    }


    @RequestMapping(value = "rapport", method = RequestMethod.POST)
    public void SaveResults(@ModelAttribute("resultForm") TestResult testResult) {

        System.out.println("Trololololo");
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView createTest(){
        blub = null;
        return new ModelAndView("createTest");
    }

    /*@RequestMapping(value="createTest", method=RequestMethod.POST)
    public ModelAndView createTest(@ModelAttribute("createTestForm") createTest test){
        ModelAndView modelAndView = new ModelAndView();
        testRepo.save((Iterable<Test>) test);
        return modelAndView;
    }*/

    @RequestMapping(value = "createTest", method=RequestMethod.POST)
    public String CreateTest(@ModelAttribute("createTestForm") createTest test){
        ModelAndView modelAndView = new ModelAndView();
        blub = test;
        createTestRepo.save(test);
        return "redirect:/test/Testform";
    }


    @RequestMapping(value = "Testform", method = RequestMethod.GET)
    public String TestForm(@RequestParam(value="code", required=false, defaultValue="0") String code, Model model){
        model.addAttribute("Joel",blub);
        //model.addAttribute("Code",blub.getCode());

        return "Testform";
    }




}
