import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example {
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

    class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    }

    public void test() {
        List<Apple> apples = new ArrayList<Apple>();

        // 1. 코드 전달
        // apples.sort(new AppleComparator());

        // 2. 람다 표현식
        // apples.sort((a1, a2) -> a1.getWeight() - a2.getWeight());

        // 3. Comparator comparing 정적 메서드 활용
        // apples.sort(comparing(apple -> apple.getWeight()));

        // 4. 메서드 참조
        apples.sort(comparing(Apple::getWeight));
    }

}
