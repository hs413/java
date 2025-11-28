import chicago.ChicagoPizzaStore;
import ny.NYPizzaStore;
import pizza.Pizza;
import pizza.PizzaStore;

public class PizzaTest {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("ny " + pizza.getName() );

        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println("chicago " + pizza2.getName() );

    }

}
