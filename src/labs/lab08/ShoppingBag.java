package labs.lab08;

import labs.lab07.Item;

import java.util.ArrayList;

import static helpers.ArrayHelper.*;

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
        return toString("extremelyRobust: " + extremelyRobust + ", ");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ShoppingBag)) return false;
        ShoppingBag bag = (ShoppingBag) o;
        if (bag.extremelyRobust != extremelyRobust) return false;
        return arrayEqualsOrderless(new ArrayList<>(bag.items), new ArrayList<>(items));
    }
}
