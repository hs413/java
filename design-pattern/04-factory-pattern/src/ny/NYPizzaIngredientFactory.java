package ny;

import ingredient.Cheese;
import ingredient.Clams;
import ingredient.Dough;
import ingredient.Pepperoni;
import ingredient.PizzaIngredientFactory;
import ingredient.Sauce;
import ingredient.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ThinCrustDough();
    }

    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Carlic(), new Onion(), new Mushroom() };
        return veggies;
    }

    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    public Clams createClams() {
        return new FreshClams();
    }


}
