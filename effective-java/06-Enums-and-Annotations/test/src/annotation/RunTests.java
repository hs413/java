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
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable t = e.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();

                    if (excType.isInstance(t)) {
                        passed++;
                    } else {
                        System.out.printf("테스트 %s 실패: 기대한 에외 %s, 발생한 예외 %s%n",
                                m, excType.getName(), t);
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
