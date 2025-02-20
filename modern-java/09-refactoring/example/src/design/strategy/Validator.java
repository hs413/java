package design.strategy;

public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String s) {
        return strategy.execute(s);
    }

    public static void test() {
        /*Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.execute("aaa");
        System.out.println(b1);

        Validator allLowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = allLowerCaseValidator.execute("aaa");
        System.out.println(b2);*/

        // 스트림 사용: 전략에 사용되는 클래스를 새로 구현하지 않아도 된다.
        Validator numericValidator = new Validator((String s) -> s.matches("[0-9]+"));
        boolean b1 = numericValidator.execute("aaa");
        System.out.println(b1);

        Validator allLowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b2 = allLowerCaseValidator.execute("aaa");
        System.out.println(b2);
    }
}
