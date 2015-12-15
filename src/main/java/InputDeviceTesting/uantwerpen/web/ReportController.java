package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.model.TestResult;
import InputDeviceTesting.uantwerpen.model.TestSequence;
import InputDeviceTesting.uantwerpen.model.TestSubject;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import InputDeviceTesting.uantwerpen.repo.TestResultRepo;
import InputDeviceTesting.uantwerpen.repo.TestSequenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by stuerjoris on 19/11/15.
 */
@Controller
@RequestMapping("/report/")
public class ReportController
{
    private final TestRepo testRepo;
    private final TestResultRepo testResultRepo;
    private final TestSequenceRepo testSequenceRepo;

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
    public ModelAndView reportTest(@PathVariable long testId)
    {
        ModelMap modelMap = new ModelMap();
        Test test =findTest(testId);
        List<TestSubject> testSubjects = test.getTestSubjects();
        List<TestSequence> testSequences = test.getTestSequences();
        double ae=0, we=0, ide=0, mt=0, er=0, tp = 0, error=0;
        int amount=0;
        int minAmp=0,maxAmp=0, minWidth=0, maxWidth=0;

        for (TestSequence testSequence: testSequences) {
            for (TestResult testResult: testSequence.getTestResultList()) {
                ae+=testResult.getAe();
                we+=testResult.getWe();
                ide+=testResult.getIDe();
                mt+=testResult.getMT();
                er+=testResult.getER();
                tp+=testResult.getTP();
                error+=testResult.getError();
                amount++;
            }
            if (minAmp!=0){
                minAmp = minAmp<testSequence.getTargetAmplitudes()? minAmp: (int) testSequence.getTargetAmplitudes();
            }
            else {
                minAmp= (int) testSequence.getTargetAmplitudes();
            }
            if (maxAmp!=0){
                maxAmp = minAmp>testSequence.getTargetAmplitudes()? minAmp: (int) testSequence.getTargetAmplitudes();
            }
            else {
                maxAmp= (int) testSequence.getTargetAmplitudes();
            }
            if (minWidth!=0){
                minWidth = minAmp<testSequence.getTargetWidth()? minAmp: (int) testSequence.getTargetWidth();
            }
            else {
                minWidth= (int) testSequence.getTargetWidth();
            }
            if (maxWidth!=0){
                maxWidth = maxWidth>testSequence.getTargetWidth()? minAmp: (int) testSequence.getTargetWidth();
            }
            else {
                maxWidth= (int) testSequence.getTargetWidth();
            }
        }
        ae/=amount;
        we/=amount;
        ide/=amount;
        mt/=amount;
        er/=amount;
        tp/=amount;
        error/=amount;

        modelMap.put("testsubjects", testSubjects.size());
        modelMap.put("testsequences", testSequences.size());
        modelMap.put("ae", ae);
        modelMap.put("we", we);
        modelMap.put("ide", ide);
        modelMap.put("mt", mt);
        modelMap.put("er", er);
        modelMap.put("tp", tp);
        modelMap.put("error", error);
        modelMap.put("minamp", minAmp);
        modelMap.put("maxamp", maxAmp);
        modelMap.put("minwidth", minWidth);
        modelMap.put("maxwidth", maxWidth);
        modelMap.put("Test", test);



        return new ModelAndView("report", modelMap);
    }
    public Test findTest(long testId){
        Test test = testRepo.findOne(testId);
        return test;
    }

    public List<Test> findAllTests() {
        return testRepo.findAll();
    }
}
