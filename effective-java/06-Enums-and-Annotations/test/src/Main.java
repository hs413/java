import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
//        planetTest(11);
        operationTest();
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
        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", a, operation, b, operation.apply(a, b));
        }

        Operation op = Operation.fromString("+").get();
        System.out.println(op.apply(a, b));
    }
}