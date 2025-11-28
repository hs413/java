package ny;

import pizza.Pizza;
import pizza.PizzaStore;

public class NYPizzaStore extends PizzaStore {


    public Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new NYCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYGreekPizza();
        } else return null;
    };
}
