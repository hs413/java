package debugging;

import java.util.Arrays;
import java.util.List;
import testing.Point;

public class Debugging {
    // 람다 표현식과 관련된 스택 트레이스는 이해하기 어려울 수 있음
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(Point::getX).forEach(System.out::println);
    }

    public static int divideByZero(int a) {
        return a / 0;
    }
}
