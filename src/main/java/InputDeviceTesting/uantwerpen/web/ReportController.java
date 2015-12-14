package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.repo.TestRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by stuerjoris on 19/11/15.
 */
@Controller
@RequestMapping("/report/")
public class ReportController
{
    TestRepo testRepo;



    @RequestMapping(value = "report", method = RequestMethod.GET)
    public String report()
    {
        return "report";
    }

    //via id in link
    @RequestMapping(value = "{testId}", method= RequestMethod.GET)
    public ModelAndView reportTest(@PathVariable long testId)
    {
        Test test = testRepo.findOne(testId);

        return new ModelAndView("report", "Test", test);
    }
}
