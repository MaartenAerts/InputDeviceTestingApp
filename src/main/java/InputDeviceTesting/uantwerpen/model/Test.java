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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String title;

    @NotNull
    @Range(min = 5,max = 25)
    private int amountTargets;

    private String description;



    @NotNull
    private double relativeErrorMax;

    @OneToMany(mappedBy = "test")
    private List<TestSequence> testSequences;

    @ManyToMany(mappedBy = "tests")
    private List<TestSubject> testSubjects;

    @NotNull
    @CreatedDate
    private LocalDateTime createdDate;
    @NotNull
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

    public int getAmountTargets() {
        return amountTargets;
    }

    public void setAmountTargets(int amountTargets) {
        this.amountTargets = amountTargets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getRelativeErrorMax() {
        return relativeErrorMax;
    }

    public void setRelativeErrorMax(double relativeErrorMax) {
        this.relativeErrorMax = relativeErrorMax;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (getId() != test.getId()) return false;
        if (getAmountTargets() != test.getAmountTargets()) return false;
        if (Double.compare(test.getRelativeErrorMax(), getRelativeErrorMax()) != 0) return false;
        if (!getTitle().equals(test.getTitle())) return false;
        if (getDescription() != null ? !getDescription().equals(test.getDescription()) : test.getDescription() != null)
            return false;
        if (!getTestSequences().equals(test.getTestSequences())) return false;
        if (getTestSubjects() != null ? !getTestSubjects().equals(test.getTestSubjects()) : test.getTestSubjects() != null)
            return false;
        if (!getCreatedDate().equals(test.getCreatedDate())) return false;
        if (!getModifiedDate().equals(test.getModifiedDate())) return false;
        return getResearchGroupList().equals(test.getResearchGroupList());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getAmountTargets();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getTestSequences().hashCode();
        result = 31 * result + (getTestSubjects() != null ? getTestSubjects().hashCode() : 0);
        temp = Double.doubleToLongBits(getRelativeErrorMax());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getCreatedDate().hashCode();
        result = 31 * result + getModifiedDate().hashCode();
        result = 31 * result + getResearchGroupList().hashCode();
        return result;
    }

    @Override
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
    }
}
