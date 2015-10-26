package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by TooLate on 16/10/2015.
 */

@RestController
@RequestMapping("/api/researcher/")
public class ResearcherController{
    @Autowired
    private ResearcherRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Researcher> findAll(){
        return (repo.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Researcher add(@RequestBody Researcher researcher){
        return repo.save(researcher);
    }

    @RequestMapping(value = "hello",method=RequestMethod.GET)
    public String hello(){
        return "YOLO";
    }

}
