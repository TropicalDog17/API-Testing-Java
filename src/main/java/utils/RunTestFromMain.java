import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.lang.reflect.Method;
import java.util.*;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectMethod;

public class RunTestFromMain {
    private String testSuiteName;

    private static final HashMap<String, ArrayList<String>> testSuitesList = new HashMap<String, ArrayList<String>>() {{
        put("LoginTest", new ArrayList<String>(List.of("0.0")));
        put("SignupTest", new ArrayList<String>(List.of("0.1")));
        put("SearchTest", new ArrayList<String>(List.of("0.30")));
        put("EditAccountTest", new ArrayList<String>(List.of("0.2")));
    }};
    SummaryGeneratingListener listener = new SummaryGeneratingListener();


    public void runTest(String testSuiteId) {
        for (String key : testSuitesList.keySet()) {
            if (testSuitesList.get(key)
                    .contains(testSuiteId)) {
                testSuiteName = key;
            }
        }
        Class TestSuiteClass = selectClass(testSuiteName).getJavaClass();
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

        //To be implemented
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
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        System.out.println(testSuiteName);
    }
}
