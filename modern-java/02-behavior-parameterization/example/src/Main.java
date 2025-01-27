import java.util.ArrayList;
import java.util.List;

public class Main {
    enum Color { RED, GREEN }

    class Apple {
        private Color color;

        public Color getColor() {
            return color;
        }
    }

    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}