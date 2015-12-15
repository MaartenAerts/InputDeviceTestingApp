package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;


/**
 * Created by stuerjoris on 14/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
@WebAppConfiguration
public class TestRepoTests {
    @Autowired
    TestRepo testRepo;
    @Test
    public void eagerAllTest(){
/*        Stream<InputDeviceTesting.uantwerpen.model.Test> tests = testRepo.eagerAll();
        assertEquals(tests.collect(Collectors.toList()).isEmpty(), false);
        System.out.println(tests);*/

    }
}
