import java.util.ArrayList;
import java.util.List;

public class PredicateExample {
    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public void test () {
        List<String> listOfString = List.of("A", "B", "C", "");
        Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfString, nonEmptyStringPredicate);
        System.out.println(nonEmpty);
    }
}
