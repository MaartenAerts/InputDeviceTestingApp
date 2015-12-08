package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.TestResult;
import InputDeviceTesting.uantwerpen.repo.TestResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Niels on 8/12/2015.
 */
@Controller
public class TestResultController {

    @Autowired
    private TestResultRepo testResultRepo;

    @ModelAttribute("allResults")
    public List<TestResult> populateResearchers() {
        List<TestResult> testResultList = testResultRepo.findAll();
        return testResultList;
    }

    @RequestMapping("/testResults")
    public String ShowDashboardPage(){return "testResults";}
}
