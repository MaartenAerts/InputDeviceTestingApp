package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

/**
 * Created by Niels on 6/11/2015.
 */
@Controller
public class RegisterController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ResearcherRepo researcherRepo;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String showRegisterPage(){
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String Register(@ModelAttribute("researcherForm") Researcher researcher){
        if (researcher != null){
            researcher.setCreatedDate(LocalDateTime.now());
            researcher.setModifiedDate(LocalDateTime.now());
            researcherRepo.save(researcher);
            System.out.println(researcher.toString() + " created");
            return "login";
        }
        System.out.println("Error");
        return "register";
    }


}
