package six;

import dish.Dish;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class SummarizationExample {
    public static void test() {
        Comparator<Dish> dishCaloriesComparator = Comparator
                .comparingInt(Dish::getcalories);

        Optional<Dish> mostCalorieDish = Dish.menu.stream()
                .collect(maxBy(dishCaloriesComparator));

        System.out.println(mostCalorieDish);


        int totalCalories = Dish.menu.stream()
                .collect(summingInt(Dish::getcalories));

        System.out.println(totalCalories);

        double avgCalories = Dish.menu.stream()
                .collect(averagingInt(Dish::getcalories));

        System.out.println(avgCalories);

        IntSummaryStatistics intSummaryStatistics = Dish.menu.stream()
                .collect(summarizingInt(Dish::getcalories));

        System.out.println(intSummaryStatistics);

        String shortMenu = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));

        System.out.println(shortMenu);

        int totalCalories2 = Dish.menu.stream()
                .collect(reducing(0, Dish::getcalories, Integer::sum));

//        int totalCalories2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();

        System.out.println(totalCalories2);
    }

}
