package InputDeviceTesting.uantwerpen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by TooLate on 5/11/2015.
 */
@Controller
@RequestMapping("/test/")
public class TestController {
    @RequestMapping("test")//Todo:moet {id} worden
    public ModelAndView getTest(){
        return new ModelAndView("test");
    }

    public ModelAndView createTest(){
        return new ModelAndView();
    }


}
