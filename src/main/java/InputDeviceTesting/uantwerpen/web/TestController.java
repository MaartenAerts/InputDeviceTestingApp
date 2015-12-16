package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.*;
import InputDeviceTesting.uantwerpen.repo.*;

import InputDeviceTesting.uantwerpen.service.CreateTestForm;
import InputDeviceTesting.uantwerpen.service.TestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private TestSequenceRepo testSequenceRepo;

    @Autowired
    private TestSubjectRepo testSubjectRepo;

    private Test test;

    private TestSequence testSequence;

    private List<TestSequence> testSequenceList;

    private List<TestSubject> testSubjectList;

    private TestResult testResult;



    @ModelAttribute("allDevices")
    public List<Device> populateDevices() {
        List<Device> deviceList = deviceRepo.findAll();
        return deviceList;
    }


    @ModelAttribute("Tests")
    public List<Test> populateTests(){
        List<Test> testList = testRepo.findAll();
        return testList;
    }

    private List<TestSubject> testSubjectListAll;

    @ModelAttribute("alltestsubjects")
    public List<TestSubject> populataTestSubjects()
    {
        testSubjectListAll = testSubjectRepo.findAll();
        return testSubjectListAll;
    }

    @ModelAttribute("seqList")
    public List<TestSequence> populateTestSequences() {
        return this.testSequenceList;
    }

    @ModelAttribute("subList")
    public List<TestSubject> populateTestSubjects() {
        return this.testSubjectList;
    }


    @RequestMapping(value ="/{id}")
    public ModelAndView getTest(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("test");

        Test blub  = testRepo.findById(id);
        modelAndView.addObject("TestObj", blub);

       // TestSequence blubSequence = this.testSequenceList;
        //modelAndView.addObject("TestSeqObj", blubSequence);
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
    public String createTest(Model model){
            model.addAttribute("test",new Test());
        testSequenceList = new ArrayList<>();
        testSubjectList = new ArrayList<>();
        //model.addAttribute("testSequence",new CreateTestForm());
        return "createTest";
    }

    /*@RequestMapping(value="createTest", method=RequestMethod.POST)
    public ModelAndView createTest(@ModelAttribute("createTestForm") createTest test){
        ModelAndView modelAndView = new ModelAndView();
        testRepo.save((Iterable<Test>) test);
        return modelAndView;
    }*/

    @RequestMapping(value = "createTest", method=RequestMethod.POST, params = {"saveTest"})
    public String CreateTest(@ModelAttribute("test") Test test,CreateTestForm lol,BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("formErrors","Form has " + bindingResult.getErrorCount() +" invalid or empty values");
            //model.addAttribute("AllSequences", testSequenceList);
            return ("createTest");
        }
        if(test.getTitle()=="" || test.getTitle().isEmpty()){
            model.addAttribute("formErrors","Test needs a title!!!");
            //model.addAttribute("AllSequences", testSequenceList);
            return ("createTest");
        }
        if(testSequenceList.isEmpty()){
            model.addAttribute("seqErrors","Sequence cannot be empty!!!");
            return ("createTest");
        }
        //Wa doede gij mij aan Cri: ;'(
        test.setDevice(deviceRepo.findByName(test.getDeviceName()));
        test.setTestSequences(testSequenceList);
        test.setCreatedDate(LocalDateTime.now());
        test.setModifiedDate(LocalDateTime.now());
        test.setTestSubjects(testSubjectList);
//        testSequenceRepo.save(testSequenceList);
        testSequenceList.clear();
        testSubjectList.clear();
        testRepo.save(test);
        redirectAttributes.addFlashAttribute("test", "Test created!");
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "createTest", params = {"addSequence"})
    public ModelAndView AddSequence(TestSequence testSequence,BindingResult bindingResult,Model model){
        ModelAndView modelAndView = new ModelAndView("createTest");
        testSequence.setSequenceIndex(testSequenceList.size());
        testSequence.setDifficulty((Math.log(testSequence.getTargetAmplitudes()/testSequence.getTargetWidth())+1)/Math.log(2));
        testSequenceList.add(testSequence);
        return modelAndView;

    }

    @RequestMapping(value = "createTest", params = {"addSubject"})
    public ModelAndView AddSubject(TestSubject testSubject,BindingResult bindingResult,Model model){
        ModelAndView modelAndView = new ModelAndView("createTest");
        if(testSubjectList.contains(testSubject)==false) {
            for(TestSubject ts : testSubjectListAll) {
                if(ts.getEmail().equals(testSubject.getEmail())) {
                    testSubjectList.add(ts);
                }
            }
        }
        return modelAndView;

    }



    @RequestMapping(value = "addsequencetotest", method = RequestMethod.GET)
    public String TestForm(@RequestParam(value="code", required=false, defaultValue="0") String code, Model model){
        //model.addAttribute("Joel",blub);
        //model.addAttribute("Code",blub.getCode());
        return "addsequencetotest";
    }




}
