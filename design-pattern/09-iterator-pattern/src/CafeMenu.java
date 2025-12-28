import java.awt.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu implements Menu{
    Map<String, MenuItem> menuItems = new HashMap<String, MenuItem>();


    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name, item);
    }

    public Iterator<MenuItem> iterator() {
        return menuItems.values().iterator();
    }
}
