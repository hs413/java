import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppleExample {
    enum Color { RED, GREEN }

    class Apple {
        private Color color;
        private int weight;

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(String color, int weight) {
            this.color = Color.valueOf(color);
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }
    }

    public void test() {
        Supplier<Apple> c1 = Apple::new; // () -> new Apple();
        Apple a1 = c1.get();

        Function<Integer, Apple> c2 = Apple::new; // (weight) -> new Apple(weight);
        Apple a2 = c2.apply(110);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        BiFunction<String, Integer, Apple> c3 = Apple::new; // (color, weight) -> new Apple(color, weight);
        Apple a3 = c3.apply("red", 110);
    }

    public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
