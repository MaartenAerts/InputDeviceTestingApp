package InputDeviceTesting.uantwerpen.model.tests;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
//import InputDeviceTesting.uantwerpen.model.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;

/**
 * Created by Joelg on 3/12/2015.
 * Voor elke @test zal zowel @Before als @After opgestart worden
 * setUp() wordt voor de test uitgevoerd, nadien tearDown().
 * https://www.youtube.com/watch?v=hYg0Y1hMEus
 */

/**
 * Resultaten:
 *  Researchers toevoegen werkt
 *  Researcher deleten werkt niet
 *  Aantal researchers rechtstreeks aanpassen (via get&set) werkt niet
 *  Test toevoegen werkt
 *  Aantal testen rechtstreeks aanpassen (via get&set) werkt niet
 *  ID van groep aanpassen (via get&set) werkt
 *  Compare functie voor ID werkt
 */
public class ResearchGroupTest {

    private ResearchGroup res, res2, res3;
    private Researcher researcher1, researcher2;
    private InputDeviceTesting.uantwerpen.model.Test test1; //Lange beschrijving vanwege naamconflict Test met 'java.util.ArrayList'

    @Before
    public void setUp() throws Exception {
        res = new ResearchGroup();
        res2 = new ResearchGroup();
        res3 = new ResearchGroup();
        researcher1 = new Researcher();
        researcher2 = new Researcher();
        test1= new InputDeviceTesting.uantwerpen.model.Test();
    }

    @After
    public void tearDown() throws Exception {
        res = null;
        res2 = null;
        res3 = null;
        researcher1 = null;
        researcher2 = null;
        test1 = null;
    }

    @Test
    public void testResearcherlist(){
        //aanmaken van 2 researchers
        researcher1.setFirstName("Jan");
        researcher1.setLastName("Pet");
        researcher2.setFirstName("Piet");
        researcher2.setLastName("Hoed");

        //Toevoegen aan researchgroup res2
        res2.addResearcher(researcher1);
        res2.addResearcher(researcher2);

        //Controleren of aantal researchers in researchgroup effectief 2 is
        long expected = 2;
        long actual = res2.getAmountOfResearchers();
        assertEquals(expected,actual, 0);

        //Researcher deleten werkt niet!
        //res2.deleteResearcher("Pet");

        //Aantal researchers rechtstreeks aanpassen testen (werkt niet!)
        res2.setAmountOfResearchers(5);
        long expected2 = 5;
        long actual2 = res2.getAmountOfResearchers();
        assertEquals(expected2,actual2, 0);

        //List<Researcher> actual = new ArrayList<Researcher>();
        //actual = res2.getResearcherList();
    }

    @Test
    public void testAmountofTests(){
        //Test toevoegen
        res2.addTest(test1);
        long expected2 = 1;
        long actual2 = res2.getAmountOfTests();
        assertEquals(expected2,actual2, 0);

        //Test getter en setter (werkt niet!)
        res3.setAmountOfTests(45);
        long expected = 45;
        long actual = res3.getAmountOfTests();
        assertEquals(expected,actual, 0);
    }

    @Test
    public void testSetandGetID(){
        //Test getter en setter
        res.setId(12);
        long expected = 12;
        long actual = res.getId();
        assertEquals(expected,actual, 0);

        //Compare testen
        res2.setId(15);
        long expected2 = 3;
        long actual2 = res2.compareTo(res);
        assertEquals(expected2,actual2, 0);

    }
}