package adapter;

public class DuckTest {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("turkey says");
        turkey.gobble();
        turkey.fly();

        System.out.println("\n duck says");
        testDuck(duck);

        System.out.println("\n adapter says");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
