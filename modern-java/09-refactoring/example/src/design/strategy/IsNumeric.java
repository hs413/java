package design.strategy;

public class IsNumeric implements ValidationStrategy{
    public boolean execute(String s) {
        return s.matches("[0-9]+");
    }
}
