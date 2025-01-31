package six;

import static java.util.stream.Collectors.*;

import dish.Dish;
import java.util.List;
import java.util.Map;

public class GroupExample {
    public enum CaloricLevel { DIET, NORMAL, FAT }

    public static void test() {
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishedByCaloricLevel = Dish.menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getcalories() <= 400) return CaloricLevel.DIET;
                    else if(dish.getcalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));

        System.out.println(dishedByCaloricLevel);

        // FISH가 없다
        Map<Dish.Type, List<Dish>> dishedByCaloricLevel2 = Dish.menu.stream()
                .filter(dish -> dish.getcalories() > 500)
                .collect(groupingBy(Dish::getType));

        System.out.println(dishedByCaloricLevel2);

        // FISH를 빈 배열로
        Map<Dish.Type, List<Dish>> dishedByCaloricLevel3 = Dish.menu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getcalories() > 500, toList())
                ));

        System.out.println(dishedByCaloricLevel3);

        Map<Dish.Type, List<String>> dishNamesByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        System.out.println(dishNamesByType);

        // 다수준 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Dish.menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getcalories() <= 400) return CaloricLevel.DIET;
                            else if(dish.getcalories() <= 700) return CaloricLevel.NORMAL;
                            return CaloricLevel.FAT;
                        })));

        System.out.println(dishesByTypeCaloricLevel);
    }
}
