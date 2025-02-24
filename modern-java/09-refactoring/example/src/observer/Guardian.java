package observer;

public class Guardian implements Observer{
    public void notify(String message) {
        if (message != null && message.contains("queen")) {
            System.out.println("Yet more new from in London " + message);
        }
    }

}
