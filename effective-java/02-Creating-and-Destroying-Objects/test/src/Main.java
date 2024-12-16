import static pizza.NyPizza.Size.SMALL;
import static pizza.Pizza.Topping.HAM;
import static pizza.Pizza.Topping.ONION;
import static pizza.Pizza.Topping.SAUSAGE;

import builder.NutritionFacts;
import pizza.Calzone;
import pizza.NyPizza;

public class Main {
    public static void main(String[] args) {
        Main.builderTest();

        Main.builderTest2();

    }

    private static void builderTest() {
        // 사용 예
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .fat(10)
                .build();

        System.out.println("a");
    }

    private static void builderTest2() {
        // 사용 예
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone pizza2 = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println("a");
    }
}



