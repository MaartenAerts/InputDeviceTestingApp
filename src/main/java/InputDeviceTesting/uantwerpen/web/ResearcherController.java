package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


/**
 * Created by TooLate on 16/10/2015.
 */

@RestController
@RequestMapping("/api/researcher/")
public class ResearcherController{
    @Autowired
    private ResearcherRepo researcherRepo;


    @RequestMapping(method = RequestMethod.GET)
    public List<Researcher> findAll(){
        return (researcherRepo.findAll());
    }

    //Retrieve single researcher
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Researcher> getResearcher(@PathVariable("id") long id) {

        System.out.println("Retrieving researcher with id " + id);
        Researcher researcher = researcherRepo.findById(id);
        if(researcher == null){
            System.out.println("Researcher with id " + id + " not found");
            return new ResponseEntity<Researcher>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Researcher>(researcher, HttpStatus.OK);
    }

    //Create researcher
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createResearcher(@RequestBody Researcher researcher,    UriComponentsBuilder ucBuilder) {

        System.out.println("Creating researcher " + researcher.getEmail());
        if (researcherRepo.exists(researcher.getId())){
            System.out.println("A researcher with id: " + researcher.getId() + " email: " + researcher.getEmail() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        researcherRepo.save(researcher);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(researcher.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Update researcher
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Researcher> updateResearcher(@PathVariable("id") long id, @RequestBody Researcher researcher) {

        System.out.println("Updating researcher " + id);
        Researcher currentResearcher = researcherRepo.findById(id);

        if (currentResearcher==null) {
            System.out.println("Researcher with id " + id + " not found");
            return new ResponseEntity<Researcher>(HttpStatus.NOT_FOUND);
        }

        currentResearcher.setEmail(researcher.getEmail());
        currentResearcher.setPassword(researcher.getPassword());
        currentResearcher.setFirstName(researcher.getFirstName());

        researcherRepo.save(currentResearcher);

        return new ResponseEntity<Researcher>(currentResearcher, HttpStatus.OK);
    }

    //Delete researcher
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Researcher> deleteResearcher(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Researcher researcher = researcherRepo.findById(id);
        if (researcher == null) {
            System.out.println("Unable to delete. Researcher with id " + id + " not found");
            return new ResponseEntity<Researcher>(HttpStatus.NOT_FOUND);
        }

        researcherRepo.delete(researcher);
        return new ResponseEntity<Researcher>(HttpStatus.NO_CONTENT);
    }

    //Delete all researchers
    @RequestMapping(value = "/deleteAll/", method = RequestMethod.DELETE)
    public ResponseEntity<Researcher> deleteAllResearchers() {
        System.out.println("Deleting All Researchers");

        researcherRepo.deleteAll();
        return new ResponseEntity<Researcher>(HttpStatus.NO_CONTENT);
    }

    /*@RequestMapping(params={"save"},method = RequestMethod.POST)
    public String save(@RequestBody Researcher researcher){ //Save , add , insert, update = hetzelfde.
        customUserDetailsService.save(researcher);
        return "addResearcher";
    }*/

    @RequestMapping(value = "hello",method=RequestMethod.GET)
    public String hello(){
        return "YOLO";
    }

    private Researcher genereteResearcher(int j){
        Researcher researcher = new Researcher("mail@mail.com","pass");
        return researcher;
    }

}
