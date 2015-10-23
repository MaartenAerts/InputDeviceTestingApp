package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TooLate on 16/10/2015.
 */
@RestController
public class ResearcherController {

    /*@Autowired
    private ResearcherRepo researcherRepo;*/

    @RequestMapping("/")
    public String home(){


       /* Researcher researcher = new Researcher();
        researcher.setFirstName("Niels");
        researcher.setLastName("Vervliet");
        researcher.setEmail("Niels@email.com");
        researcher.setUserName("user1");
        researcher.setPassword("root");

        researcherRepo.save(researcher);
        System.out.println("Person::" + researcher);
        Iterable<Researcher> iterable = researcherRepo.findAll();

        for(Researcher r : iterable){
            System.out.println("Person List::"+r);
        }*/

        return "Hello, world";
    }
}
