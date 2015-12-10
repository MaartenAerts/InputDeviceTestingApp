package InputDeviceTesting.uantwerpen.model;

import org.hibernate.validator.constraints.Range;
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

    private String title;

    private String Device;
    private int Targets;
    private long errorThreshold;
    private long Sequences;
    private long Difficulty;
    private long AmplitudeMin;
    private long AmplitudeMax;
    private long WidthMin;
    private long WidthMax;
    private String ColorMain;
    private String ColorTargets;
    private String ColorNext;
    private String ColorPrevious;
    private String ColorMissed;

    @OneToMany(mappedBy = "test")
    private List<TestSequence> testSequences;

    @ManyToMany(mappedBy = "tests")
    private List<TestSubject> testSubjects;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @ManyToMany(mappedBy = "testList")
    private List<ResearchGroup> researchGroupList = new ArrayList<ResearchGroup>();



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

    public String getDevice() {
        return Device;
    }

    public void setDevice(String device) {
        Device = device;
    }

    public int getTargets() {
        return Targets;
    }

    public void setTargets(int targets) {
        Targets = targets;
    }

    public long getErrorThreshold() {
        return errorThreshold;
    }

    public void setErrorThreshold(long errorThreshold) {
        this.errorThreshold = errorThreshold;
    }

    public long getSequences() {
        return Sequences;
    }

    public void setSequences(long sequences) {
        Sequences = sequences;
    }

    public long getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(long difficulty) {
        Difficulty = difficulty;
    }

    public long getAmplitudeMin() {
        return AmplitudeMin;
    }

    public void setAmplitudeMin(long amplitudeMin) {
        AmplitudeMin = amplitudeMin;
    }

    public long getAmplitudeMax() {
        return AmplitudeMax;
    }

    public void setAmplitudeMax(long amplitudeMax) {
        AmplitudeMax = amplitudeMax;
    }

    public long getWidthMin() {
        return WidthMin;
    }

    public void setWidthMin(long widthMin) {
        WidthMin = widthMin;
    }

    public long getWidthMax() {
        return WidthMax;
    }

    public void setWidthMax(long widthMax) {
        WidthMax = widthMax;
    }

    public String getColorMain() {
        return ColorMain;
    }

    public void setColorMain(String colorMain) {
        ColorMain = colorMain;
    }

    public String getColorTargets() {
        return ColorTargets;
    }

    public void setColorTargets(String colorTargets) {
        ColorTargets = colorTargets;
    }

    public String getColorNext() {
        return ColorNext;
    }

    public void setColorNext(String colorNext) {
        ColorNext = colorNext;
    }

    public String getColorPrevious() {
        return ColorPrevious;
    }

    public void setColorPrevious(String colorPrevious) {
        ColorPrevious = colorPrevious;
    }

    public String getColorMissed() {
        return ColorMissed;
    }

    public void setColorMissed(String colorMissed) {
        ColorMissed = colorMissed;
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


    /*@Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", amountTargets=" + amountTargets +
                ", description='" + description + '\'' +
                ", testSequences=" + testSequences +
                ", testSubjects=" + testSubjects +
                ", relativeErrorMax=" + relativeErrorMax +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", researchGroupList=" + researchGroupList +
                '}';
    }*/
}
