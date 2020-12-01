package labs.lab08;

import java.util.ArrayList;

import static helpers.ArrayHelper.arrayListEqualsOrderless;

public class HandHoldBag extends Bag {
    private boolean premiumQuality;
    public HandHoldBag(boolean premiumQuality) {
        super(5);
        this.premiumQuality = premiumQuality;
    }

    @Override
    public String toString() {
        String string = "{ totalCapacity: " + totalCapacity + ", usedCapacity: " + usedCapacity +
                ", premiumQuality: " + premiumQuality + ", items: { ";
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
        if (!(o instanceof HandHoldBag)) return false;
        HandHoldBag bag = (HandHoldBag) o;
        if (bag.premiumQuality != premiumQuality) return false;
        return arrayListEqualsOrderless(new ArrayList<>(bag.items), new ArrayList<>(items));
    }
}
