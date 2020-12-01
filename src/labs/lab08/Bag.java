package labs.lab08;

import labs.lab07.Item;

public class Bag {
    private static final int minCapacity = 1;
    private Item[] items;
    private int totalCapacity, usedCapacity = 0;

    public Bag(int totalCapacity) throws IllegalArgumentException {
        if (totalCapacity < minCapacity) throw new IllegalArgumentException("Invalid totalCapacity: " + totalCapacity);
        this.totalCapacity = totalCapacity;
        items = new Item[totalCapacity];
    }
}
