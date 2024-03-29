package InputDeviceTesting.uantwerpen.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niels on 5/10/2015.
 */


@Entity
public class TestSubject implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String illness;
    private String description;
    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Test> tests;
    @OneToMany(mappedBy = "testSubject", cascade = CascadeType.ALL)
    List<TestResult> testResultList= new ArrayList<TestResult>();

    public TestSubject() {
    }

    public TestSubject(String firstName, String lastName, String illness, String description, String email, Test test) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.illness = illness;
        this.description = description;
        this.email = email;
        this.addTest(test);
    }

    public TestSubject(String firstName, String lastName, String illness, String description, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.illness = illness;
        this.description = description;
        this.email = email;
    }

    public void addTest(Test test) {
        if (tests == null){
            tests = new ArrayList<Test>();
        }
        tests.add(test);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<TestResult> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        testResultList.stream().forEach(tr-> tr.setTestSubject(this));
        this.testResultList = testResultList;
    }

    @Override
    public String toString() {
        return "TestSubject:[ Id = " + this.id + "firstName = " + this.firstName + "lastName = " + this.lastName + "email = " + this.email
                + "illness = " + this.illness + "description = " + this.description + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        return this.email.equals(((TestSubject)obj).email);
    }
}
