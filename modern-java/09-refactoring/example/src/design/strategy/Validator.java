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
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.execute("aaa");
        System.out.println(b1);

        Validator allLowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = allLowerCaseValidator.execute("aaa");
        System.out.println(b2);
    }
}
