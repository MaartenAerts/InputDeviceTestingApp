package InputDeviceTesting.uantwerpen.service;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.model.TestSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niels on 15/12/2015.
 */
public class CreateTestForm {

   private List<TestSequence> testSequences;

    public List<TestSequence> getTestList() {
        return testSequences;
    }

    public void setTestList(List<TestSequence> testSequences) {
        this.testSequences = testSequences;
    }
}
