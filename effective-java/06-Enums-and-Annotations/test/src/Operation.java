import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    // switch 문을 사용한 값에 따라 분기하는 열거 타입
    /*PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double a, double b) {
        switch (this) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case TIMES:
                return a * b;
            case DIVIDE:
                return a / b;
        }
        throw new AssertionError("알 수 없는 연산: " + this);
    }*/

    // 상수별 메서드 구현을 활용한 열거 타입
    /*PLUS { public double apply(double a, double b) { return a + b; } },
    MINUS { public double apply(double a, double b) { return a - b; } },
    TIMES { public double apply(double a, double b) { return a * b; } },
    DIVIDE { public double apply(double a, double b) { return a / b; } };

    public abstract double apply(double a, double b);*/

    // 상수별 클래스 몸체와 데이터를 사용한 열거 타입

    PLUS("+") {
        public double apply(double a, double b) { return a + b; }
    },
    MINUS("-") {
        public double apply(double a, double b) { return a - b; }
    },
    TIMES("*") {
        public double apply(double a, double b) { return a * b; }
    },
    DIVIDE("/") {
        public double apply(double a, double b) { return a / b; }
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    @Override public String toString() { return symbol; }
    public abstract double apply(double a, double b);

    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(
                    Collectors.toMap(Objects::toString, e -> e));

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

}
