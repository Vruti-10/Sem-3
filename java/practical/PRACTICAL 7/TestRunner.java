import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class TestCases {

    @Run
    public void testLogin() {
        System.out.println("Login test passed");
    }

    @Run
    public void testSignup() {
        System.out.println("Signup test passed");
    }

    public void normalTest() {
        System.out.println("This will not run");
    }
}

public class TestRunner {

    public static void main(String[] args) throws Exception {

        TestCases test = new TestCases();
        int count = 0;

        Method[] methods = TestCases.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(test);
                count++;
            }
        }
        System.out.println("Total tests run: " + count);
    }
}