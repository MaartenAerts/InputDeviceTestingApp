package InputDeviceTesting.uantwerpen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameResearchGroupController {

    @RequestMapping("/NameResearchGroup")
    String index(){
        return "NameResearchGroup";
    }
    }
