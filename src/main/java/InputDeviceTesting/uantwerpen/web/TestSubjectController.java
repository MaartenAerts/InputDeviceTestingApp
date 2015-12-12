package InputDeviceTesting.uantwerpen.web;

/**
 * Created by Niels on 30/10/2015.
 */

import InputDeviceTesting.uantwerpen.model.TestSubject;
import InputDeviceTesting.uantwerpen.repo.TestSubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping("/testsubjects/")
public class TestSubjectController
{
    @Autowired
    private TestSubjectRepo testSubjectRepo;

    @RequestMapping(value= "testsubjects", method = RequestMethod.GET)
    public String report() {return "testsubjects";}

    @ModelAttribute("alltestsubjects")
    public List<TestSubject> populataTestSubjects()
    {
        List<TestSubject> testSubjectList = testSubjectRepo.findAll();
        return testSubjectList;
    }

    @RequestMapping(value = "NewTestSubject", method = RequestMethod.POST)
    public String Register(@ModelAttribute("SubjectForm") TestSubject testSubject)
    {
        testSubjectRepo.save(testSubject);
        return "redirect:/testsubject/testsubject";
    }


}