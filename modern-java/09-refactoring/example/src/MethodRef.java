import static java.util.stream.Collectors.*;

import dish.Dish;
import dish.Dish.CaloricLevel;
import java.util.List;
import java.util.Map;

public class MethodRef {

    public static void test() {
        // Map<CaloricLevel, List<Dish>> dishedByCaloricLevel = Dish.menu.stream()
        //         .collect(groupingBy(dish -> {
        //             if (dish.getcalories() <= 400) return CaloricLevel.DIET;
        //             else if(dish.getcalories() <= 700) return CaloricLevel.NORMAL;
        //             else return CaloricLevel.FAT;
        //         }));

        // 람다를 메서드 참조로 수정
        Map<CaloricLevel, List<Dish>> dishedByCaloricLevel = Dish.menu.stream()
                .collect(groupingBy(Dish::getCaloricLevel));

        System.out.println(dishedByCaloricLevel);

        // 메서드 참조가 의도를 더 정확히 보여준다.
        // inventory.sort(
        //         (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())
        // );

        // inventory.sort(comparing(Apple::getWeight));

        // 저수준 리듀싱 연산 조합
        // int totalCalories = menu.stream()
        //         .map(Dish::getcalories)
        //         .reduce(0, (c1, c2) -> c1 + c2);

        // int totalCalories = menu.stream().collect(summingInt(Dish::getcalories));

    }
}
