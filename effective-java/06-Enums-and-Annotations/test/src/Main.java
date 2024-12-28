public class Main {

    public static void main(String[] args) {
        planetTest(11);

    }

    public static void planetTest(double mass) {
        System.out.println(Planet.EARTH.surfaceWeight(3));
        System.out.println(Planet.EARTH.surfaceGravity());

        for (Planet planet : Planet.values()) {
            System.out.printf("%s에서의 무게는 %f이다. %n", planet, planet.surfaceWeight(mass));
        }
    }
}