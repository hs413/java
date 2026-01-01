public class MenuTest {

//    public static void main(String[] args) {
//        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//        DinerMenu dinerMenu = new DinerMenu();
//        CafeMenu cafeMenu = new CafeMenu();
//        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
//        waitress.printMenu();
//    }

    public static void main(String[] args) {
        MenuComponent pancakeMenu = new Menu("pancake menu", "breakfast ");
        MenuComponent dinerMenu = new Menu("diner menu", "lunch ");
        MenuComponent cafeMenu = new Menu("cafe menu", "eat");
        MenuComponent dessertMenu = new Menu("dessert menu", "salad ");

        MenuComponent allMenus = new Menu("all menu", "salad ");

        allMenus.add(pancakeMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("pasta", "ddff", true, 3.99));

        dessertMenu.add(new MenuItem("dessert", "abs", true, 1.52));

        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();
    }
}
