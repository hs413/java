import java.util.List;

public class PancakeMenuIterator implements Iterator {
    List<MenuItem> menuItems;
    int position = 0;

    public PancakeMenuIterator(List<MenuItem> items) {
        this.menuItems = items;
    }

    public MenuItem next() {
        MenuItem item = menuItems.get(position);
        position = position + 1;
        return item;
    }

    public boolean hasNext() {
        if (position < menuItems.size() || menuItems.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }
}
