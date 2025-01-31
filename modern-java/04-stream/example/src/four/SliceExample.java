package four;

import dish.Dish;
import java.util.List;
import java.util.stream.Collectors;

public class SliceExample {
    public static List<Dish> menu = List.of(
            new Dish("seasonal fruit",true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
    );

    public static void usePredicate() {
        // filter: 전체 요소를 검사
        List<Dish> dishes1 = menu.stream()
                .filter(dish -> {
                    System.out.println("filtter: " + dish);
                    return dish.getcalories() < 320;
                })
                .collect(Collectors.toList());

        System.out.println(dishes1);

        // takeWhile: 조건에 부합하지 않는 경우 작업 중단
        // 정렬되어 있는 스트림의 경우 유용
        List<Dish> dishes2 = menu.stream()
                .takeWhile(dish -> {
                    System.out.println("take while: " + dish);
                    return dish.getcalories() < 320;
                })
                .collect(Collectors.toList());

        System.out.println(dishes2);

        // dropWhile: takeWhile의 결과와 반대
        List<Dish> dishes3 = menu.stream()
                .dropWhile(dish -> dish.getcalories() < 320)
                .collect(Collectors.toList());

        System.out.println(dishes3);
    }
}
