import java.util.List;

public class ConsumerExample {
    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    public static  <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void test () {
        List<String> listOfString = List.of("A", "B", "C", "");
        forEach(listOfString, c -> System.out.println(c));
    }
}
