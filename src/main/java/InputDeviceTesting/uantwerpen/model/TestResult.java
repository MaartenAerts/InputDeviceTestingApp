package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Niels on 26/11/2015.
 */
@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;


    //@OneToMany(mappedBy = "test")
    //private List<Test> testList;

    //@ManyToMany(mappedBy = "tests")
    //private List<TestSubject> testSubjects;

    @OneToOne
    @PrimaryKeyJoinColumn
    private TestSequence testsequence;

    //Task Conditions
    private double trials;
    private double A;
    private double W;

    //Movement behaviour
    private double Ae;
    private double  We;
    private double IDe;
    private double error;

    //Participent Info
    private double MT;
    private double ER;
    private double TP;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TestSequence getTestsequence() {
        return testsequence;
    }

    public void setTestsequence(TestSequence testsequence) {
        this.testsequence = testsequence;
    }

    public double getTrials() {
        return trials;
    }

    public void setTrials(double trials) {
        this.trials = trials;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getW() {
        return W;
    }

    public void setW(double w) {
        W = w;
    }

    public double getAe() {
        return Ae;
    }

    public void setAe(double ae) {
        Ae = ae;
    }

    public double getWe() {
        return We;
    }

    public void setWe(double we) {
        We = we;
    }

    public double getIDe() {
        return IDe;
    }

    public void setIDe(double IDe) {
        this.IDe = IDe;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getMT() {
        return MT;
    }

    public void setMT(double MT) {
        this.MT = MT;
    }

    public double getER() {
        return ER;
    }

    public void setER(double ER) {
        this.ER = ER;
    }

    public double getTP() {
        return TP;
    }

    public void setTP(double TP) {
        this.TP = TP;
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
