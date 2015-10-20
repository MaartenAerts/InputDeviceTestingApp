package org.uantwerpen.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TooLate on 16/10/2015.
 */
@RestController
public class ResearcherController {
    @RequestMapping("/")
    public String home(){
        return "Hello, world";
    }
}
