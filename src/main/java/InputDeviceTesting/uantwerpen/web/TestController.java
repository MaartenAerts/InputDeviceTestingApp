package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Niels on 23/10/2015.
 */
@RestController
public class TestController {

    @ModelAttribute("data")
    public String Test(){

        return "Dit is een Test!!!";
    }

    @RequestMapping("/test")
    public ModelAndView testpage(){

        ModelAndView modelAndView = new ModelAndView("test");
        //modelAndView.addObject("data","LOLOLOLOLO");

        return modelAndView;

    }
    /*@RequestMapping(value = "/test")
    public String showHome(ModelMap model) {

        return "test";
    }*/
}


