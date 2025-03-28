package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
//        Class<?> testClass = Class.forName("annotation.Sample");
        Class<?> testClass = Class.forName("annotation.Sample2");

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;

                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패 예뢰를 던지지 않음%N", m);
                } catch (InvocationTargetException e) {
                    Throwable t = e.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes =
                            m.getAnnotation(ExceptionTest.class).value();

                    for (Class<? extends Throwable> excType : excTypes) {
                        if (excType.isInstance(t)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("테스트 %s 실패 %s %n", m,  t);
                        passed++;
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test: " + m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n",
                passed, tests - passed);
    }
}
