import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String baseUrlID = Utility.chooseBaseUrl();
        String testSuiteId = Utility.chooseAPIEndPoint(baseUrlID);
        System.out.println(testSuiteId);

        RunTestFromMain runner = new RunTestFromMain();
        runner.runTest(testSuiteId);

        TestExecutionSummary summary = runner.listener.getSummary();
        System.out.println(summary.getTestsFoundCount());
        System.out.println("Test succeeded: " + summary.getTestsSucceededCount());
        System.out.println("Test failed: " + summary.getTestsFailedCount());
    }
}

