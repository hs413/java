import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverage {
    public void brew() {
        System.out.println("brewing coffee");
    }

    public void addCondiments() {
        System.out.println("add sugar and milk");
    }

    public boolean customerWantsCondiments() {
        String answer = getUserInput()
    }

    public String getUserInput() {
        String answer = null;

        System.out.print("add sugar and milk? (y/n): ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("IO error");
        }
        if (answer == null) {
            return "no";
        }

        return answer;
    }
}
