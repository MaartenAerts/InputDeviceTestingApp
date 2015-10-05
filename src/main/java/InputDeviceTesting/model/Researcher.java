package InputDeviceTesting.model;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by TooLate on 3/10/2015.
 */
@Entity
@DynamicUpdate
public class Researcher {
    @Id
    Integer id;

    String firstname;
    String lastname;
    String email;

}
