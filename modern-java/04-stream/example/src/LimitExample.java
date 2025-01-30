import java.util.List;
import java.util.stream.Collectors;

public class LimitExample {
    public static void useLimit() {
        List<Dish> dishes = Dish.menu.stream()
                .filter(dish -> dish.getcalories() > 300)
                .limit(3)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(dishes);
    }

    public static void useSkip() {
        List<Dish> dishes = Dish.menu.stream()
                .filter(dish -> dish.getcalories() > 300)
                .skip(2)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(dishes);
    }
}
