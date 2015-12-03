package InputDeviceTesting.uantwerpen.model.tests;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Joelg on 3/12/2015.
 * Voor elke @test zal zowel @Before als @After opgestart worden
 * Bijvoorbeeld voor testGetId zal setUp() uitgevoerd worden,
 * nadien zal tearDown worden uitgevoerd.
 */
public class ResearchGroupTest {


    private ResearchGroup res, res2;
    private Researcher researcher1, researcher2;

    @Before
    public void setUp() throws Exception {
        res = new ResearchGroup();
        res2 = new ResearchGroup();
        researcher1 = new Researcher();
        researcher2 = new Researcher();
    }

    @After
    public void tearDown() throws Exception {
        res = null;
        res2 = null;
        researcher1 = null;
        researcher2 = null;
    }

    @Test
    public void testSetandGet(){
        res.setId(12);
        long expected = 12;
        long actual = res.getId();
        assertEquals(expected,actual, 0);
    }


    @Test
    public void testResearcherlist(){
        researcher1.setFirstName("Jan");
        researcher1.setLastName("Pet");
        researcher2.setFirstName("Piet");
        researcher2.setLastName("Hoed");

        res2.addResearcher(researcher1);

        long expected = 12;

        List<Researcher> actual = new ArrayList<Researcher>();
        actual = res2.getResearcherList();


    }



    @Test
    public void testAddResearcher() throws Exception {

    }

    @Test
    public void testDeleteResearcher() throws Exception {

    }

    @Test
    public void testGetAmountOfResearchers() throws Exception {

    }

    @Test
    public void testSetAmountOfResearchers() throws Exception {

    }

    @Test
    public void testGetTestList() throws Exception {

    }

    @Test
    public void testSetTestList() throws Exception {

    }

    @Test
    public void testAddTest() throws Exception {

    }

    @Test
    public void testGetAmountOfTests() throws Exception {

    }

    @Test
    public void testSetAmountOfTests() throws Exception {

    }

    @Test
    public void testGetCreatedDate() throws Exception {

    }

    @Test
    public void testSetCreatedDate() throws Exception {

    }

    @Test
    public void testGetModifiedDate() throws Exception {

    }

    @Test
    public void testSetModifiedDate() throws Exception {

    }

    @Test
    public void testCompareTo() throws Exception {

    }
}