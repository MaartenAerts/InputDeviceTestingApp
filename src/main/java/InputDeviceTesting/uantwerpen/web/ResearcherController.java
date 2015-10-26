package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by TooLate on 16/10/2015.
 */

@RestController
@RequestMapping("/api/researcher/")
public class ResearcherController{
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    //private ResearcherRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Researcher> findAll(){
        return (customUserDetailsService.findAll());
    }

    @RequestMapping(params={"save"},method = RequestMethod.POST)
    public String save(@RequestBody Researcher researcher){ //Save , add , insert, update = hetzelfde.
        customUserDetailsService.save(researcher);
        return "addResearcher";
    }

    @RequestMapping(value = "hello",method=RequestMethod.GET)
    public String hello(){
        return "YOLO";
    }

    @RequestMapping("form")
    public ModelAndView getForm(@ModelAttribute Researcher researcher) {
        return new ModelAndView("form");
    }

    @RequestMapping("register")
    public ModelAndView registerResearcher(@ModelAttribute Researcher researcher) {
        customUserDetailsService.save(researcher);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("delete")
    public ModelAndView deleteResearcher(@RequestParam Long id) {
        customUserDetailsService.deleteById(id);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping("edit")
    public ModelAndView editResearcher(@RequestParam Long id,@ModelAttribute Researcher researcher) {
        return new ModelAndView("edit", "researcher", customUserDetailsService.findById(id));
    }

    @RequestMapping("update")
    public ModelAndView updateResearcher(@ModelAttribute Researcher researcher) {
        customUserDetailsService.save(researcher);
        return new ModelAndView("redirect:list");
    }

}
