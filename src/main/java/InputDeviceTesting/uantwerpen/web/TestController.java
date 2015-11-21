package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by TooLate on 5/11/2015.
 */
@Controller
@RequestMapping("/test/")
public class TestController {
    @Autowired
    TestRepo testRepo;

    @RequestMapping(method=RequestMethod.GET)//Todo:moet {id} worden
    public ModelAndView getTest(){
        return new ModelAndView("test");
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView createTest(){
        return new ModelAndView("createTest");
    }
    @RequestMapping(value="create", method=RequestMethod.POST)
    public ModelAndView createTest(@ModelAttribute("testForm") Test test){
        testRepo.save(test);
        return new ModelAndView();
    }


}
