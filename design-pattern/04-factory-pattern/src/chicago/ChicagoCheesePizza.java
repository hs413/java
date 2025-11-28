package chicago;

import pizza.Pizza;

public class ChicagoCheesePizza extends Pizza {
    public ChicagoCheesePizza() {
        name = "Chicago Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Chicago Cheese Pizza");
    }

    public void cut() {
        System.out.println("Cutting the pizza into square");
    }

}
