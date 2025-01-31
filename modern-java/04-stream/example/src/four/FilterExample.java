package four;

import dish.Dish;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

    /**
     * predicate: boolean 타입을 반환하는 함수
     * */
    public static void usePredicate() {
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        System.out.println(vegetarianMenu);
    }


    public static void useDistinct() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 3, 3, 2, 4, 9, 10);

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct().forEach(System.out::println);
    }

}
