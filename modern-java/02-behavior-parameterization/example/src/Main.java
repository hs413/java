import java.util.ArrayList;
import java.util.List;

public class Main {
    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    public class AppleHeavyWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public class AppleGreenColorPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getColor() == Color.GREEN;
        }
    }


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

    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = List.of(new Apple(Color.GREEN), new Apple(Color.RED));
//        List<Apple> greenApples = filterApplesByColor(apples, Color.GREEN);
//        List<Apple> redApples = filterApplesByColor(apples, Color.RED);

//        System.out.println(greenApples);

//        List<Apple> result = filterApples(apples, (Apple apple) -> apple.getWeight() > 150);

        List<Apple> redApples = filter(apples, (Apple apple) -> apple.getWeight() > 150);

        List<Integer> nums = List.of(1,2,3,4,5);
        List<Integer> evenNumbers = filter(nums, (Integer i) -> i % 2 == 0);
    }
}