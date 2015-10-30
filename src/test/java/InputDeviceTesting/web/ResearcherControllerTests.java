package InputDeviceTesting.web;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Niels on 30/10/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
@WebAppConfiguration
public class ResearcherControllerTests {

    @Autowired
    ResearcherRepo researcherRepo;

    @Test
    public void testSaveResearcher(){

    }


}
