package InputDeviceTesting.uantwerpen.service;

import InputDeviceTesting.uantwerpen.model.TestResult;

import java.util.ArrayList;

/**
 * Created by Niels on 8/12/2015.
 */
public class TestResultWrapper {

    private ArrayList<Double> testResults;

    public ArrayList<Double> getTestResults() {
        return testResults;
    }

    public void setTestResults(ArrayList<Double> testResults) {
        this.testResults = testResults;
    }
}
