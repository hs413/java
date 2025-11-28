package chicago;

import pizza.Pizza;
import pizza.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {


    public Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new ChicagoCheesePizza();
        } else return null;
    };
}
