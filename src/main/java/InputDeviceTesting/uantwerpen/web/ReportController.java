package InputDeviceTesting.uantwerpen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stuerjoris on 19/11/15.
 */
@Controller
@RequestMapping("/report/")
public class ReportController
{
    @RequestMapping(value = "report", method = RequestMethod.GET)
    public String report()
    {
        return "report";
    }
}
