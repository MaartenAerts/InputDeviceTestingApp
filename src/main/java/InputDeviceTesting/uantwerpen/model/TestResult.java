package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne
    private TestSequence testsequence;

    @ManyToOne
    TestSubject testSubject;

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

    public TestResult() {
    }

    public TestResult(TestSubject testSubject, double ae, double we, double IDe, double error, double MT, double ER, double TP) {
        this.Ae = ae;
        this.We = we;
        this.IDe = IDe;
        this.error = error;
        this.MT = MT;
        this.ER = ER;
        this.TP = TP;
      //  this.testsequence= testSequence;
        this.testSubject = testSubject;

    }

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

    public TestSubject getTestSubject() {
        return testSubject;
    }

    public void setTestSubject(TestSubject testSubject) {
        this.testSubject = testSubject;
    }

    public void setTrials(Double trials) {
    }

    public void setA(Double a) {
    }

    public void setW(Double w) {
    }
}
