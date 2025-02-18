public class Main {

    public static void main(String[] args) {
        // basicTest();

        MethodRef.test();


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


}



