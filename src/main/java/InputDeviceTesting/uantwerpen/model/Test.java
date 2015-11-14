package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Niels on 5/10/2015.
 */
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    String title;
    String description;
    @OneToMany(mappedBy = "test")
    Set<TestSequence> testSequences;

    @ManyToOne
    ResearchGroup researchGroup;

    @ManyToMany(mappedBy = "tests")
    Set<TestSubject> testSubjects;
    @NotNull
    @CreatedDate
    private LocalDateTime createdDate;
    @NotNull
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Test() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TestSequence> getTestSequences() {
        return testSequences;
    }

    public void setTestSequences(Set<TestSequence> testSequences) {
        this.testSequences = testSequences;
    }

    public Set<TestSubject> getTestSubjects() {
        return testSubjects;
    }

    public void setTestSubjects(Set<TestSubject> testSubjects) {
        this.testSubjects = testSubjects;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", testSequences=" + testSequences +
                ", testSubjects=" + testSubjects +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }


}
