package six;

import static java.util.stream.Collectors.*;

import dish.Dish;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartitionExample {
    public static void test() {
        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        System.out.println(partitionedMenu);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishedByType = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegetarianDishedByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getcalories)),
                        Optional::get)));

        System.out.println(mostCaloricPartitionedByVegetarian);



    }
}
