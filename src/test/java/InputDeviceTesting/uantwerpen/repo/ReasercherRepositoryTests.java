package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.model.Researcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by Niels on 26/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
@WebAppConfiguration
public class ReasercherRepositoryTests {

    @Autowired
    ResearcherRepo researcherRepo;
    @Test
    public void testSaveProduct(){
        //setup product
        Researcher researcher = new Researcher("test@mail.com","pass");

        //save product, verify has ID value after save
        //assertNull(researcher.getId()); //null before save
        researcherRepo.save(researcher);
        assertNotNull(researcher.getId()); //not null after save

        //fetch from DB
        Researcher fetchedResearcher = researcherRepo.findOne(researcher.getId());

        //should not be null
        assertNotNull(fetchedResearcher);

        //should equal
        assertEquals(researcher.getId(), fetchedResearcher.getId());
        assertEquals(researcher.getEmail(), fetchedResearcher.getEmail());

        //update description and save
        fetchedResearcher.setEmail("TestUserNam@mail.come");
        researcherRepo.save(fetchedResearcher);

        //get from DB, should be updated
        Researcher fetchedUpdatedResearcher = researcherRepo.findOne(fetchedResearcher.getId());
        assertEquals(fetchedResearcher.getEmail(), fetchedUpdatedResearcher.getEmail());

        //verify count of products in DB
        long userCount = researcherRepo.count();
        assertEquals(userCount, 1);

        //get all products, list should only have one more then initial value
        Iterable<Researcher> researchers = researcherRepo.findAll();

        int count = 0;

        for(Researcher p : researchers){
            count++;
        }

        assertEquals(count, 1);// we starten reeds met 2 gebruikers in de database
    }

}
