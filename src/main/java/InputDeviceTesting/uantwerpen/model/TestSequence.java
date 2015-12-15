package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by TooLate on 26/10/2015.
 */
@Entity
public class TestSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int sequenceIndex;

    @OneToMany(mappedBy = "testsequence",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TestResult> testResultList;

    @ManyToOne
    Test test;

    @NotNull
    double targetAmplitudes;
    @NotNull
    double targetWidth;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public TestSequence(int sequenceIndex, double targetWidth, double targetAmplitudes) {
        this.sequenceIndex = sequenceIndex;
        this.targetWidth = targetWidth;
        this.targetAmplitudes = targetAmplitudes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TestResult> getTestResultList() {
        return testResultList;
    }

    public void setTestResultList(List<TestResult> testResultList) {
        this.testResultList = testResultList;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public double getTargetAmplitudes() {
        return targetAmplitudes;
    }

    public void setTargetAmplitudes(double targetAmplitudes) {
        this.targetAmplitudes = targetAmplitudes;
    }

    public double getTargetWidth() {
        return targetWidth;
    }

    public void setTargetWidth(double targetWidth) {
        this.targetWidth = targetWidth;
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

    public int getSequenceIndex() {
        return sequenceIndex;
    }

    public void setSequenceIndex(int sequenceIndex) {
        this.sequenceIndex = sequenceIndex;
    }


}
