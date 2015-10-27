package InputDeviceTesting.uantwerpen.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by TooLate on 26/10/2015.
 */
@Entity
public class TestSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    Test test;

    @NotNull
    @Range(min = 5,max = 25)
    int amountTargets;
    @NotNull
    double targetAmplitudes;
    @NotNull
    double targetWidth;
    @NotNull
    double relativeErrorMax;
    @NotNull
    @CreatedDate
    private LocalDateTime createdDate;

    @NotNull
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public TestSequence() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public int getAmountTargets() {
        return amountTargets;
    }

    public void setAmountTargets(int amountTargets) {
        this.amountTargets = amountTargets;
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

    @Override
    public String toString() {
        return "TestSequence{" +
                "id=" + id +
                ", test=" + test +
                ", amountTargets=" + amountTargets +
                ", targetAmplitudes=" + targetAmplitudes +
                ", targetWidth=" + targetWidth +
                ", relativeErrorMax=" + relativeErrorMax +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestSequence that = (TestSequence) o;

        if (getId() != that.getId()) return false;
        if (getAmountTargets() != that.getAmountTargets()) return false;
        if (Double.compare(that.getTargetAmplitudes(), getTargetAmplitudes()) != 0) return false;
        if (Double.compare(that.getTargetWidth(), getTargetWidth()) != 0) return false;
        if (Double.compare(that.getRelativeErrorMax(), getRelativeErrorMax()) != 0) return false;
        if (!getTest().equals(that.getTest())) return false;
        if (!getCreatedDate().equals(that.getCreatedDate())) return false;
        return getModifiedDate().equals(that.getModifiedDate());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTest().hashCode();
        result = 31 * result + getAmountTargets();
        temp = Double.doubleToLongBits(getTargetAmplitudes());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTargetWidth());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getRelativeErrorMax());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getCreatedDate().hashCode();
        result = 31 * result + getModifiedDate().hashCode();
        return result;
    }

}
