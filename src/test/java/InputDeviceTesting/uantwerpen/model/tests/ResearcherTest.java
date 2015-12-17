package InputDeviceTesting.uantwerpen.model.tests;

import InputDeviceTesting.uantwerpen.model.Role;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import InputDeviceTesting.uantwerpen.model.Researcher;

import static org.junit.Assert.*;


/**
 * Created by Joelg on 10/12/2015.
 */
public class ResearcherTest {

    private Researcher researcher1, researcher2, researcher3;
    private List<Role> role1, role2 = new ArrayList<Role>();

    @Before
    public void setUp() throws Exception {

        researcher1 = new Researcher("test@test.te", "test");
        researcher2 = new Researcher();
        researcher3 = new Researcher();

    }

    @After
    public void tearDown() throws Exception {

        researcher1 = null;
        researcher2 = null;

    }



    @Test
    public void testGetSetID() throws Exception {
        //Eenvoudige get-set-test
        researcher1.setId(400);
        long expected = 400;
        long actual = researcher1.getId();
        assertEquals(expected,actual);
    }

    @Test
    public void testEmailEqual() throws Exception {
        //email van twee researchers kunnen vergelijken
        String email1  = "1@test.te";
        String email2  = "2@test.te";

        researcher1.setEmail(email1);
        researcher2.setEmail(email2);
        researcher3.setEmail(email1);

        boolean expected = false;
        boolean actual = researcher1.equals(researcher2);
        assertEquals(expected,actual);

        boolean expected2 = true;
        boolean actual2 = researcher1.equals(researcher3);
        assertEquals(expected2,actual2);
    }

    @Test
    public void testCompareID(){
        //Volgorde testen
        researcher1.setId(200);
        researcher2.setId(150);
        long expected = 50;
        long actual = researcher1.compareTo(researcher2);
        assertEquals(expected,actual);

    }
}