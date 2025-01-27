import java.util.ArrayList;
import java.util.List;

public class Main {
    enum Color { RED, GREEN }

    static class Apple {
        private Color color;
        private int weight;

        public Apple(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
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

    public static List<Apple> filterApplesByColor(List<Apple> apples, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> apples, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (flag && apple.getColor().equals(color) ||
            !flag && apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = List.of(new Apple(Color.GREEN), new Apple(Color.RED));
        List<Apple> greenApples = filterApplesByColor(apples, Color.GREEN);
        List<Apple> redApples = filterApplesByColor(apples, Color.RED);

        System.out.println(greenApples);
    }
}