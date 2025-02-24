package observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void notifyObservers(String message) {
        observers.forEach(o -> o.notify(message));
    }
}
