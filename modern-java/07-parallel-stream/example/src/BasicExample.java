import java.util.stream.Stream;

public class BasicExample {
    public static void test() {
        long result = parallelSum(5);
        System.out.println(result);
    }

    private static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel() // 스트림을 병렬 스트림으로 변환
                .reduce(0L, Long::sum);

        // .sequential()을 사용해서 병렬 스트림을 순차 스트림으로 바꿀 수 있다.
    }


}
