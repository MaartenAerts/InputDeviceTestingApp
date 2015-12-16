package InputDeviceTesting.web;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.web.ReportController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;
import static org.junit.Assert.*;


/**
 * Created by TooLate on 14/12/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
@WebAppConfiguration
public class ReportControllerTests {
    @Autowired
    ReportController reportController;

    @Test
    public void testAverageThroughput(){
        ModelAndView modelAndView= reportController.reportTest(1);
        InputDeviceTesting.uantwerpen.model.Test test =
                (InputDeviceTesting.uantwerpen.model.Test)modelAndView.getModel().get("Test");
        assertNotNull(test);
        assertNotNull(test.getTestSequences());
        assertNotNull(test.getTestSequences().get(0).getTestResultList());
    }

}
