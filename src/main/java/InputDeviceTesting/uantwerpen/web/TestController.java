package InputDeviceTesting.uantwerpen.web;

import org.springframework.stereotype.Controller;
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
    @RequestMapping(method=RequestMethod.GET)//Todo:moet {id} worden
    public ModelAndView getTest(@RequestParam int testId){
        return new ModelAndView("test");
    }

    @RequestMapping("create")
    public ModelAndView createTest(){
        return new ModelAndView("createTest");
    }


}
