package InputDeviceTesting.uantwerpen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by stuerjoris on 21/11/15.
 */
@Controller
@RequestMapping("/navbar/")
public class NavbarController {
    @RequestMapping(value = "navbar", method = RequestMethod.GET)
    public String report()
    {
        return "navbar";
    }
}
