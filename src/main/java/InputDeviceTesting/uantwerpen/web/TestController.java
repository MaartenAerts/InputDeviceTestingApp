package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.*;
import InputDeviceTesting.uantwerpen.repo.DeviceRepo;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import InputDeviceTesting.uantwerpen.repo.TestResultRepo;
import InputDeviceTesting.uantwerpen.repo.TestSubjectRepo;
import InputDeviceTesting.uantwerpen.service.TestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by TooLate on 5/11/2015.
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private TestResultRepo testResultRepo;


    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private TestSubjectRepo testSubjectRepo;

    private Test blub;

    private TestResult testResult;

    @ModelAttribute("allDevices")
    public List<Device> populateDevices() {
        List<Device> deviceList = deviceRepo.findAll();
        return deviceList;
    }

    @ModelAttribute("alltestsubjects")
    public List<TestSubject> populataTestSubjects()
    {
        List<TestSubject> testSubjectList = testSubjectRepo.findAll();
        return testSubjectList;
    }



    @RequestMapping(value ="/{id}")
    public ModelAndView getTest(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("test");
        blub  = testRepo.findById(id);
        modelAndView.addObject("TestObj", blub);

        return modelAndView;
    }


    @RequestMapping(value = "rapport", method = RequestMethod.POST)
    public String SaveResults(@ModelAttribute("resultForm")TestResultWrapper testResultWrapper) {

        //System.out.println("Trololololo");
        int amountOfObjects = (testResultWrapper.getTestResults().size())/10;
        for (int i = 0; i < amountOfObjects; i++){
            testResult = new TestResult();
            testResult.setTrials(testResultWrapper.getTestResults().get(i*10));
            testResult.setA(testResultWrapper.getTestResults().get((i*10)+1));
            testResult.setW(testResultWrapper.getTestResults().get((i*10)+2));
            testResult.setAe(testResultWrapper.getTestResults().get((i * 10) + 3));
            testResult.setWe(testResultWrapper.getTestResults().get((i * 10) + 4));
            testResult.setIDe(testResultWrapper.getTestResults().get((i * 10) + 5));
            testResult.setError(testResultWrapper.getTestResults().get((i * 10) + 6));
            testResult.setMT(testResultWrapper.getTestResults().get((i * 10) + 7));
            testResult.setER(testResultWrapper.getTestResults().get((i * 10) + 8));
            testResult.setTP(testResultWrapper.getTestResults().get((i * 10) + 9));
            testResult.setCreatedDate(LocalDateTime.now());
            testResult.setModifiedDate(LocalDateTime.now());

            testResultRepo.save(testResult);
        }
        return "redirect:/testResults";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView createTest(){
        blub = null;
        return new ModelAndView("createTest");
    }

    /*@RequestMapping(value="createTest", method=RequestMethod.POST)
    public ModelAndView createTest(@ModelAttribute("createTestForm") createTest test){
        ModelAndView modelAndView = new ModelAndView();
        testRepo.save((Iterable<Test>) test);
        return modelAndView;
    }*/

    @RequestMapping(value = "createTest", method=RequestMethod.POST)
    public String CreateTest(@ModelAttribute("createTestForm") Test test,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("formErrors","Form has " + bindingResult.getErrorCount() +" invalid or empty values");
            return "createTest";
        }
        if(test.getTitle()=="" || test.getTitle().isEmpty()){
            model.addAttribute("formErrors","Test needs a title!!!");
            return "createTest";
        }
        //test.setDevice(deviceRepo.findByDevice(test.getDeviceString()));
        ModelAndView modelAndView = new ModelAndView();
        test.setCreatedDate(LocalDateTime.now());
        test.setModifiedDate(LocalDateTime.now());
        testRepo.save(test);
        return "redirect:/test/addsequencetotest";
    }


    @RequestMapping(value = "addsequencetotest", method = RequestMethod.GET)
    public String TestForm(@RequestParam(value="code", required=false, defaultValue="0") String code, Model model){
        //model.addAttribute("Joel",blub);
        //model.addAttribute("Code",blub.getCode());
        return "addsequencetotest";
    }




}
