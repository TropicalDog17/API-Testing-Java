import java.lang.reflect.Method;
import java.util.*;

public class Display {

    public static void displayTestSuite(String routeAPI) {

        try {
            Class testClass = Class.forName(Constant.TEST_SUITES.get(routeAPI)); //Dua vao user
            // input, nhan biet la su dung test case

            Method[] testSuiteMethods = testClass.getMethods(); //test methods should be public
            for (Method e : testSuiteMethods) {
                String testName = e.getName();
                //Ignore some built-in class methods
                if (Constant.IGNORED_CLASS_METHODS.contains(testName) == false) {
                    System.out.println(testName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
