package pizza;

public class Pizza {

    public Pizza orderPizza(String type) {
        Pizza pizza = new Pizza();


        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new GreekPizza();
        }


        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }




    public void prepare() {

    }

    public void bake() {

    }

    public void cut() {
    }

    public void box() {}
}
