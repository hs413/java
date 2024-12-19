import composition.InstrumentedHashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("A", "BB", "C"));

        System.out.println(s.getAddCount());
    }
}