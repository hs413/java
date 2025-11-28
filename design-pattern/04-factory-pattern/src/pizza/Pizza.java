package pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();


    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("dough: " + dough);

        for(String topping : toppings) {
            System.out.println(topping);
        }
    }

    public void bake() {
        System.out.println("baking");
    }

    public void cut() {
        System.out.println("cutting");
    }

    public void box() {
        System.out.println("boxing");
    }

    public String getName() {
        return name;
    }
}
