package dish;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;


public class Dish {
    public enum CaloricLevel { DIET, NORMAL, FAT }
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;


    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName () {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getcalories () {
        return calories;
    }
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
    public enum Type { MEAT, FISH, OTHER }

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit",true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH)
    );

    public static void test() {
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getcalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());

        System.out.println(names);
    }

    public CaloricLevel getCaloricLevel() {
        if (this.getcalories() <= 400)
            return CaloricLevel.DIET;
        else if(this.getcalories() <= 700)
            return CaloricLevel.NORMAL;
        else
            return CaloricLevel.FAT;
    }
}
