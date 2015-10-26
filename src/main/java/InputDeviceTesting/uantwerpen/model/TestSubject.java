package InputDeviceTesting.uantwerpen.model;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Niels on 26/10/2015.
 */

@Entity
public class TestSubject {

    String firstname;
    String lastname;
    String email;
    String Illness;
    String Description;
    Date DateOfBirth;
}

