package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.TestSubject;
import InputDeviceTesting.uantwerpen.repo.TestSubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Niels on 30/10/2015.
 */
@RestController
public class TestSubjectController {

    @Autowired
    private TestSubjectRepo testSubjectRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<TestSubject> findAll(){
        return (testSubjectRepo.findAll());
    }
}
