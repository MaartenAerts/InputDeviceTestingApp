package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.model.TestResult;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import InputDeviceTesting.uantwerpen.repo.TestResultRepo;
import InputDeviceTesting.uantwerpen.repo.TestSequenceRepo;
import org.hibernate.jpa.criteria.ValueHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by stuerjoris on 19/11/15.
 */
@Controller
@RequestMapping("/report/")
public class ReportController
{
    TestRepo testRepo;
    TestResultRepo testResultRepo;
    TestSequenceRepo testSequenceRepo;

    @Autowired
    public ReportController(TestRepo testRepo, TestResultRepo testResultRepo, TestSequenceRepo testSequenceRepo) {
        this.testRepo = testRepo;
        this.testResultRepo = testResultRepo;
        this.testSequenceRepo = testSequenceRepo;
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public String report()
    {
        return "report";
    }

    //via id in link
    @RequestMapping(value = "{testId}", method= RequestMethod.GET)
    public String reportTest(@PathVariable long testId)
    {


      // List<Test> tests = IntStream.range(1,4).map(i -> testRepo.findByDifficulty(i)).collect(Collectors.toList()) ;
       // List<Double> averageByDifficulty = testResultRepo.avgByDifficulty();
        //List<Test> tests= testRepo.eagerAll();







        return "report";
    }

    private double getAverageByTest(long testId){
        //List<TestResult> testResults= testResultRepo.findByTestId(testId);
        double averageThroughput=0;


        //testResults.stream().mapToDouble(TestResult::getTP).average();
        //testResults.stream().mapToDouble(TestResult::getTP).average();


        return new Double(0);
    }


}
