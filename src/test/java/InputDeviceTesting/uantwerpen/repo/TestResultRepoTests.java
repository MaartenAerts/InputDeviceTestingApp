package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by stuerjoris on 14/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
@WebAppConfiguration
public class TestResultRepoTests {
    @Autowired
    TestResultRepo testResultRepo;

/*    @Test
    public void avgByDifficultyTest(){
        List<Double> results = testResultRepo.avgByDifficulty();
        System.out.println(results);
    }*/



}
