package four;

import dish.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void useMap() {
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(dishNames);

        List<String> words = List.of("AAAA", "BB", "CCCCCCCC", "DDDDDD");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(wordLengths);
    }

    public static void useFlatMap() {
        List<String> words = List.of("Hello", "World");

//        words.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .forEach(System.out::println);

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
