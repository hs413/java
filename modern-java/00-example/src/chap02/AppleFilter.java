package chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleFilter {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(Color.GREEN),
                new Apple(Color.GREEN),
                new Apple(Color.RED));

        List<Apple> filtered = filteringGreenApples(inventory);

        filtered.forEach(System.out::println);
    }

    enum Color {
        RED,
        GREEN
    }

    public static List<Apple> filteringGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor()))
                result.add(apple);
        }

        return result;
    }


    public static class Apple {
        private Color color;

        public Apple(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("Apple{color=%s}", color);
        }
    }
}
