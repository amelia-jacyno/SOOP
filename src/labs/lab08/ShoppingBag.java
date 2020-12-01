package labs.lab08;

import labs.lab07.Item;

import java.util.ArrayList;

import static helpers.ArrayHelper.arrayListEqualsOrderless;

public class ShoppingBag extends Bag {
    private boolean extremelyRobust;
    public ShoppingBag(boolean extremelyRobust) {
        super(30);
        this.extremelyRobust = extremelyRobust;
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item i : items) {
            totalWeight = i.getTotalWeight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        String string = "{ totalCapacity: " + totalCapacity + ", usedCapacity: " + usedCapacity +
                ", extremelyRobust: " + extremelyRobust + ", items: { ";
        for (int i = 0; i < items.size(); i++) {
            string += items.get(i);
            if (i < items.size() - 1) string += ", ";
        }
        string += "}}";
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ShoppingBag)) return false;
        ShoppingBag bag = (ShoppingBag) o;
        if (bag.extremelyRobust != extremelyRobust) return false;
        return arrayListEqualsOrderless(new ArrayList<>(bag.items), new ArrayList<>(items));
    }
}
