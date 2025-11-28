package pizza;

public abstract class PizzaStore {
//    pizza.SimplePizzaFactory simplePizzaFactory;
//
//    public pizza.PizzaStore(pizza.SimplePizzaFactory simplePizzaFactory) {
//        this.simplePizzaFactory = simplePizzaFactory;
//    }


    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
