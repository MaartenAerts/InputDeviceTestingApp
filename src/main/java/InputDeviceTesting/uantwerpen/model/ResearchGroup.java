package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Niels on 13/11/2015.
 */
@Entity
public class ResearchGroup implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "RESEARCHERGOUP_ID")
    private long id;

    private String groupName;

    private String creator;

    @ManyToMany(mappedBy = "researchGroups")
    private Set<Researcher> researchers;
    private int amountOfResaerchers;
    @OneToMany(mappedBy = "researchGroup")
    private Set<Test> tests;
    private int amountOfTests;

    @NotNull
    @CreatedDate
    private LocalDateTime createdDate;
    @NotNull
    @LastModifiedDate
    private LocalDateTime modifiedDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Set<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(Set<Researcher> researchers) {
        this.researchers = researchers;
    }

    public void addResearcher(Researcher researcher){
        researchers.add(researcher);
        amountOfResaerchers++;
    }

    public void deleteResearcher(String researcherName){

    }

    public int getAmountOfResaerchers() {
        return amountOfResaerchers;
    }

    public void setAmountOfResaerchers(int amountOfResaerchers) {
        this.amountOfResaerchers = amountOfResaerchers;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
    public void addTest(Test test){
        tests.add(test);
        amountOfTests++;
    }

    public int getAmountOfTests() {
        return amountOfTests;
    }

    public void setAmountOfTests(int amountOfTests) {
        this.amountOfTests = amountOfTests;
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
}
