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


    public static void printNumbers() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // forEach를 호출하는 순간 전체 스트림이 소비된다
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);



        List<Integer> result = numbers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(java.util.stream.Collectors.toList());
    }

}
