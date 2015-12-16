package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.service.CreateTestForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niels on 16/12/2015.
 */
@Controller
public class FormTestControll {

   /* private static List<Test> testList = new ArrayList<Test>();

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get() {

        CreateTestForm createTestForm = new CreateTestForm();
        createTestForm.setTestList(testList);

        return new ModelAndView("add_contact" , "contactForm", createTestForm);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("contactForm") CreateTestForm createTestForm) {
        System.out.println(createTestForm);
        System.out.println(createTestForm.getTestList());
        List<Test> contacts = createTestForm.getTestList();

        if(null != contacts && contacts.size() > 0) {
            FormTestControll.testList = contacts;
            for (Test test : contacts) {
                System.out.printf("%s \t %s \n", test.getTitle());
            }
        }

        return new ModelAndView("show_contact", "contactForm", createTestForm);
    }*/

}
