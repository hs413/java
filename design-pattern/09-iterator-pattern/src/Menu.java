import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent  {
    List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent get(int index) {
        return menuComponents.get(index);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n " + getName());
        System.out.println(", " + getDescription());
        System.out.println(" ----------------------- ");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }

    }
}
