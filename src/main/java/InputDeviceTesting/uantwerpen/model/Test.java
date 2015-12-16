package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niels on 5/10/2015.
 */
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Device device;
    private String deviceName;

    @NotNull
    private int targets;
    @NotNull
    private long errorThreshold;
    @NotNull
    private long sequences;
    @NotNull
    private String colorMain;
    @NotNull
    private String colorTargets;
    @NotNull
    private String colorNext;
    @NotNull
    private String colorPrevious;
    @NotNull
    private String colorMissed;

    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TestSequence> testSequences;

    @ManyToMany(mappedBy = "tests", fetch = FetchType.EAGER)
    private List<TestSubject> testSubjects;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToOne
    private ResearchGroup researchGroup;

    public Test() {
    }

    public Test(String title, Device device, int targets, long errorThreshold, String colorMain, String colorTargets, String colorNext, String colorPrevious, String colorMissed) {
        this.title = title;
        this.device = device;
        this.targets = targets;
        this.errorThreshold = errorThreshold;
        this.colorMain = colorMain;
        this.colorTargets = colorTargets;
        this.colorNext = colorNext;
        this.colorPrevious = colorPrevious;
        this.colorMissed = colorMissed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeviceName() {return deviceName;}

    public void setDeviceName(String deviceName) {this.deviceName = deviceName;}

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getTargets() {
        return targets;
    }

    public void setTargets(int targets) {
        this.targets = targets;
    }

    public long getErrorThreshold() {
        return errorThreshold;
    }

    public void setErrorThreshold(long errorThreshold) {
        this.errorThreshold = errorThreshold;
    }

    public long getSequences() {
        return sequences;
    }

    public void setSequences(long sequences) {
        this.sequences = sequences;
    }


    public String getColorMain() {
        return colorMain;
    }

    public void setColorMain(String colorMain) {
        this.colorMain = colorMain;
    }

    public String getColorTargets() {
        return colorTargets;
    }

    public void setColorTargets(String colorTargets) {
        this.colorTargets = colorTargets;
    }

    public String getColorNext() {
        return colorNext;
    }

    public void setColorNext(String colorNext) {
        this.colorNext = colorNext;
    }

    public String getColorPrevious() {
        return colorPrevious;
    }

    public void setColorPrevious(String colorPrevious) {
        this.colorPrevious = colorPrevious;
    }

    public String getColorMissed() {
        return colorMissed;
    }

    public void setColorMissed(String colorMissed) {
        this.colorMissed = colorMissed;
    }

    public List<TestSequence> getTestSequences() {
        return testSequences;
    }

    public void setTestSequences(List<TestSequence> testSequences) {
        testSequences.stream().forEach(ts -> ts.setTest(this));
        this.testSequences = testSequences;
    }

    public List<TestSubject> getTestSubjects() {
        if( testSubjects==null){
            testSubjects = new ArrayList<TestSubject>();
        }
        return testSubjects;
    }

    public void setTestSubjects(List<TestSubject> testSubjects) {
        testSubjects.stream().forEach(ts -> ts.addTest(this));
        this.testSubjects = testSubjects;
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

    public ResearchGroup getResearchGroup() {
        return researchGroup;
    }

    public void setResearchGroup(ResearchGroup researchGroup) {
        this.researchGroup = researchGroup;
    }

    public void addTestSequence(TestSequence testSequence) {
        if (this.testSequences!= null){
            testSequences.add(testSequence);
        }
        else{
            testSequences = new ArrayList<TestSequence>();
            testSequences.add(testSequence);
        }
    }
}
