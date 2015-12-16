package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niels on 13/11/2015.
 */

@Entity
public class ResearchGroup implements Serializable , Comparable<ResearchGroup> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "RESEARCHERGOUP_ID")
    private long id;

    private String groupName;

    private Researcher creator;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="RESEARCHERGOUP_RESEARCHER", joinColumns={@JoinColumn(name="RESEARCHERGOUP_ID")}, inverseJoinColumns={@JoinColumn(name="RESEARCHER_ID")})
    private List<Researcher> researcherList = new ArrayList<Researcher>();
    private int amountOfResearchers;
    @OneToMany(mappedBy = "researchGroup", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Test> testList = new ArrayList<Test>();
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

    public Researcher getCreator() {
        return creator;
    }

    public void setCreator(Researcher creator) {
        this.creator = creator;
    }

    public List<Researcher> getResearcherList() {
        return researcherList;
    }

    public void setResearcherList(List<Researcher> researcherList) {
        this.researcherList = researcherList;
    }

    public void addResearcher(Researcher researcher){
        researcherList.add(researcher);
        amountOfResearchers++;
    }

    public void deleteResearcher(String researcherName){

    }

    public int getAmountOfResearchers() {
       amountOfResearchers = researcherList.size();
        return amountOfResearchers;
    }

    public void setAmountOfResearchers(int amountOfResaerchers) {
        this.amountOfResearchers = amountOfResaerchers;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }
    public void addTest(Test test){
        testList.add(test);
        amountOfTests++;
    }

    public int getAmountOfTests() {
        amountOfTests = testList.size();
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

    @Override
    public int compareTo(ResearchGroup o) {
        long compareQuantity = ((ResearchGroup) o).getId();


        //ascending order
        return (int)this.id - (int)compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;
    }
}
