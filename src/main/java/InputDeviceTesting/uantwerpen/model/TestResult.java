package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Niels on 26/11/2015.
 */
@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;


    //@OneToMany(mappedBy = "test")
    //private List<Test> testList;

    //@ManyToMany(mappedBy = "tests")
    //private List<TestSubject> testSubjects;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
