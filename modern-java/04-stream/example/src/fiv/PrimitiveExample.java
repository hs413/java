package fiv;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveExample {

    public static void test() {
        // 숫자 기본형 스트림
        int calories = Dish.menu.stream()
                .mapToInt(Dish::getcalories)
                .sum();

        // 스트림 복원
        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getcalories);
        Stream<Integer> stream = intStream.boxed();

        // OptionalInt
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getcalories)
                .max();

        // 숫자 범위
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);


    }
}
