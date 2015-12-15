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

    private String deviceString;

    @ManyToOne
    private  Device device;
    @NotNull
    private int targets;
    @NotNull
    private long errorThreshold;
    @NotNull
    private long sequences;
    @NotNull
    private long difficulty;
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

    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER)
    private List<TestSequence> testSequences;

    @ManyToMany(mappedBy = "tests")
    private List<TestSubject> testSubjects;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToMany(mappedBy = "testList")
    private List<ResearchGroup> researchGroupList = new ArrayList<ResearchGroup>();

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

    public String getDeviceString() {
        return deviceString;
    }

    public void setDeviceString(String deviceString) {
        this.deviceString = deviceString;
    }

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

    public long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(long difficulty) {
        this.difficulty = difficulty;
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
        this.testSequences = testSequences;
    }

    public List<TestSubject> getTestSubjects() {
        return testSubjects;
    }

    public void setTestSubjects(List<TestSubject> testSubjects) {
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

    public List<ResearchGroup> getResearchGroupList() {
        return researchGroupList;
    }

    public void setResearchGroupList(List<ResearchGroup> researchGroupList) {
        this.researchGroupList = researchGroupList;
    }


}
