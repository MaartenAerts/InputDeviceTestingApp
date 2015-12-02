package InputDeviceTesting.uantwerpen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stuerjoris on 1/12/15.
 */

@Controller
@RequestMapping("/devices/")
public class DevicesController
{
    @RequestMapping(value = "devices", method = RequestMethod.GET)
    public String report()
    {
        return "devices";
    }
}
