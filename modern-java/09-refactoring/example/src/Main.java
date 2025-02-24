import design.strategy.Validator;
import design.templatemethod.Customer;
import design.templatemethod.OnlineBankingLambda;
import dish.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import observer.Feed;
import observer.Guardian;
import observer.LeMonde;
import observer.NYTimes;

public class Main {

    public static void main(String[] args) {
        // basicTest();
        // MethodRef.test();
//        Validator.test();
//        new OnlineBankingLambda().processCustomer(13, (Customer c) -> System.out.println(c));

        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("Then queen");

    }

    public static void basicTest() {
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        };

        Runnable r2 = () -> System.out.println("hello");

        int a = 10;
        Runnable r11 = () -> {
            // 람다는 블록 스코프가 적용되지 않는다?
            // 변수를 가릴 수 없다?
            // int a = 2; // 컴파일 에러
            System.out.println(a);
        };

        Runnable r22 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };
    }

    // 명령형 데이터 처리를 스트림으로
    public static void test() {
        List<String> dishNames = new ArrayList<>();
        for(Dish dish: Dish.menu) {
            if (dish.getcalories() > 300) {
                dishNames.add(dish.getName());
            }
        }

        Dish.menu.parallelStream()
                .filter(dish -> dish.getcalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}



