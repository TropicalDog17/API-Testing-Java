import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;

import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.lang.reflect.Method;
import java.util.*;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectMethod;

public class RunTestFromMain {
    private String testSuiteName;
    private final HashMap<String, ArrayList<String>> testSuitesList = Constant.TEST_SUITES_LIST;

    SummaryGeneratingListener listener = new SummaryGeneratingListener();


    public void runTest(String testSuiteId) {
        for (String key : testSuitesList.keySet()) {
            if (testSuitesList.get(key)
                    .contains(testSuiteId)) {
                testSuiteName = key;
            }
        }
        Class<?> TestSuiteClass = selectClass(testSuiteName).getJavaClass();
        Method[] methodList = TestSuiteClass.getDeclaredMethods();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a test case: " + "0-" + (methodList.length - 1));
        System.out.println("Enter: run all test cases");
        //Print all test case
        for (int i = 0; i < methodList.length; i++) {
            System.out.println(i + ": " + methodList[i].getName());
        }
        //User choose test case to run
        String index = sc.nextLine()
                .trim();
        System.out.println(index);


        LauncherDiscoveryRequest request;
        if (index.isEmpty()) {
            request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(selectClass(testSuiteName)) //Run all test
                    .build();
        } else {
            int intIndex = Integer.parseInt(index);
            request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(selectMethod(selectClass(testSuiteName).getJavaClass(), methodList[intIndex].getName())) //Run
                    .build();
        }
        Launcher launcher = LauncherFactory.create();
        launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        System.out.println(testSuiteName);
    }

    public void displayTestResult() {
        TestExecutionSummary summary = this.listener.getSummary();
        System.out.println(summary.getTestsFoundCount());
        System.out.println("Test succeeded: " + summary.getTestsSucceededCount());
        System.out.println("Test failed: " + summary.getTestsFailedCount());
        List<TestExecutionSummary.Failure> failedTests = summary.getFailures();
        if (failedTests.size() > 0) {
            for (TestExecutionSummary.Failure test : failedTests) {
                System.out.println(test.getTestIdentifier()
                        .getDisplayName());
                System.out.println(test.getException()
                        .toString());
            }
        }
    }
}
