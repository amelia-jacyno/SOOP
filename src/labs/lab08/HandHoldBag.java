package labs.lab08;

import java.util.ArrayList;

import static helpers.ArrayHelper.*;

public class HandHoldBag extends Bag {
    private boolean premiumQuality;
    public HandHoldBag(boolean premiumQuality) {
        super(5);
        this.premiumQuality = premiumQuality;
    }

    @Override
    public String toString() {
        return toString("premiumQuality: " + premiumQuality + ", ");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof HandHoldBag)) return false;
        HandHoldBag bag = (HandHoldBag) o;
        if (bag.premiumQuality != premiumQuality) return false;
        return arrayEqualsOrderless(new ArrayList<>(bag.items), new ArrayList<>(items));
    }
}
