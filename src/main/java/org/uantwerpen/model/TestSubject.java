package org.uantwerpen.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Niels on 5/10/2015.
 */
@Entity
@DynamicUpdate
//@DynamicInsert //Is dit Nodig????
public class TestSubject {
    @Id
    Integer id;

    String firstname;
    String lastname;
    String email;
    String Illness;
    String Description;
    Date DateOfBirth;
}
