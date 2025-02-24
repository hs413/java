package observer;

public class LeMonde implements Observer{
    public void notify(String message) {
        if (message != null && message.contains("wine")) {
            System.out.println("Today cheese, wine  " + message);
        }
    }

}
