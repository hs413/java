//import Plant.LifeCycle;
import extension.ExtendedOperation;
import extension.Operation;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
//        planetTest(11);
//        operationTest();
//        payrollTest();
//        plantTest();
        operationTest2();
    }

    public static void planetTest(double mass) {
        System.out.println(Planet.EARTH.surfaceWeight(3));
        System.out.println(Planet.EARTH.surfaceGravity());

        for (Planet planet : Planet.values()) {
            System.out.printf("%s에서의 무게는 %f이다. %n", planet, planet.surfaceWeight(mass));
        }
    }

    public static void operationTest() {
//        System.out.println(Operation.PLUS.apply(1, 2));

        double a = 1;
        double b = 2;
        /*for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", a, operation, b, operation.apply(a, b));
        }

        Operation op = Operation.fromString("+").get();
        System.out.println(op.apply(a, b));*/
    }

    public static void payrollTest() {
        System.out.println(PayrollDay.Monday.pay(480, 2));
        System.out.println(PayrollDay.Monday.pay(960, 2));
        System.out.println(PayrollDay.Sunday.pay(480, 2));
    }

    public static void plantTest() {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

       /* for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle));

        Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), Collectors.toSet()));*/

        System.out.println(plantsByLifeCycle);

    }

    public static void operationTest2() {
        double x = 4;
        double y = 2;
        test(ExtendedOperation.class, x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {

        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}