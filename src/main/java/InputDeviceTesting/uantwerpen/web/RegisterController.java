package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Role;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView Register(@ModelAttribute("researcherForm") Researcher researcher){

        ModelAndView modelAndView = new ModelAndView();
        if (researcher.getEmail() != "" && researcher.getEmail() != null && researcher.getPassword() != null){

            System.out.println("Creating researcher " + researcher.getEmail());

            if (researcherRepo.exists(researcher.getId())){
                System.out.println("A researcher with id: " + researcher.getId() + " email: " + researcher.getEmail() + " already exist");
                modelAndView.addObject("ResearcherExists","Researcher with this id/email already exists!!!");
                modelAndView.setViewName("register");
                return modelAndView;
            } else if (researcherRepo.findByEmail(researcher.getEmail()) != null){
                System.out.println("A researcher with id: " + researcher.getId() + " email: " + researcher.getEmail() + " already exist");
                modelAndView.addObject("ResearcherExists","Researcher with this id/email already exists!!!");
                modelAndView.setViewName("register");
                return modelAndView;
            }
            researcher.setCreatedDate(LocalDateTime.now());
            researcher.setModifiedDate(LocalDateTime.now());
            researcher.addRole(new Role("RESEARCHER"));
            researcherRepo.save(researcher);
            System.out.println(researcher.toString() + " created");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        System.out.println("Error");
        modelAndView.setViewName("register");
        return modelAndView;
    }


}
