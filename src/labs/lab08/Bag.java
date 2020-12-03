package labs.lab08;

import labs.lab07.Item;
import labs.lab07.ProductType;

import java.util.ArrayList;
import java.util.Iterator;

import static helpers.ArrayHelper.*;

public class Bag {
    private static final int minCapacity = 1;
    protected ArrayList<Item> items = new ArrayList<>();
    protected int totalCapacity, usedCapacity = 0;

    public Bag(int totalCapacity) throws IllegalArgumentException {
        if (totalCapacity < minCapacity)
            throw new IllegalArgumentException("Invalid totalCapacity: " + totalCapacity);
        this.totalCapacity = totalCapacity;
    }

    public void removeAllItems() {
        items.clear();
        usedCapacity = 0;
    }

    public boolean remove(ProductType type) {
        return remove(type, usedCapacity);
    }

    public boolean remove(ProductType type, int n) {
        boolean removed = false;
        Iterator<Item> i = items.iterator();
        while (i.hasNext() && n > 0) {
            Item item = i.next();
            if (item.getType() == type) {
                if (item.getQuantity() > n) {
                    item.removeItems(n);
                    usedCapacity -= n;
                    return true;
                }
                n -= item.getQuantity();
                usedCapacity -= item.getQuantity();
                i.remove();
                removed = true;
            }
        }
        return removed;
    }

    public boolean putIn(Item item) {
        if (usedCapacity + item.getQuantity() > totalCapacity) return false;
        items.add(item);
        usedCapacity += item.getQuantity();
        return true;
    }

    @Override
    public String toString() {
        return toString("");
    }

    protected String toString(String injection) {
        String string = "{ " + injection + "totalCapacity: " + totalCapacity + ", usedCapacity: " + usedCapacity + ", items: { ";
        string += arrayToString(new ArrayList<>(items));
        string += "}}";
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Bag)) return false;
        Bag bag = (Bag) o;
        if (bag.totalCapacity != totalCapacity) return false;
        return arrayEqualsOrderless(new ArrayList<>(bag.items), new ArrayList<>(items));
    }
}
