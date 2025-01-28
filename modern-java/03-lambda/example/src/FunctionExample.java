import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionExample {
    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    public static <T, R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(f.apply(t));
        }

        return result;
    }

    // [7, 2, 6]
    public static void test () {
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                s -> s.length()
        );

        System.out.println(l);
    }
}
