package labs.lab08;

import labs.lab07.Item;
import labs.lab07.ProductType;

import static helpers.ConsoleHelper.*;

public class Controller {
    public static void main(String[] args) {

        // TODO: Save tests to a text file and display them as line-to-line comparison (expected == got)

        // TEST Constructors & toString()

        Bag bag = new Bag(25);
        HandHoldBag handHoldBag = new HandHoldBag(true);
        ShoppingBag shoppingBag = new ShoppingBag(true);
        try {
            new Bag(0);
        } catch (IllegalArgumentException e) {
            println(e);
        }
        println(bag);
        println(handHoldBag);
        println(shoppingBag);
        println();

        // TEST putIn()

        Item[] items = {
                new Item(ProductType.BREAD, 3),
                new Item(ProductType.BUTTER, 2),
                new Item(ProductType.MILK, 5),
                new Item(ProductType.TEA, 8)
        };
        for (Item i : items) {
            println(bag.putIn(new Item(i.getType(), i.getQuantity())));
            println(handHoldBag.putIn(new Item(i.getType(), i.getQuantity())));
            println(shoppingBag.putIn(new Item(i.getType(), i.getQuantity())));
        }
        println(bag);
        println(handHoldBag);
        println(shoppingBag);
        println();

        // TEST remove(ProductType, int)

        for (Item i : items) {
            println(bag.remove(i.getType(), 1));
            println(handHoldBag.remove(i.getType(), 2));
            println(shoppingBag.remove(i.getType(), 3));
        }
        println(bag);
        println(handHoldBag);
        println(shoppingBag);
        println();

        // TEST remove(ProductType)

        println(bag.remove(ProductType.BREAD));
        println(shoppingBag.remove(ProductType.MILK));

        println(bag);
        println(shoppingBag);
        println();

        // TEST removeAll()

        bag.removeAllItems();
        handHoldBag.removeAllItems();
        shoppingBag.removeAllItems();

        println(bag);
        println(handHoldBag);
        println(shoppingBag);
        println();

        // TEST equals()

        println(bag.equals(new Bag(25)));
        println(bag.equals(new Bag(20)));
        println(handHoldBag.equals(new HandHoldBag(true)));
        println(handHoldBag.equals(new HandHoldBag(false)));
        for (Item i : items) {
            shoppingBag.putIn(i);
        }
        ShoppingBag comparisonBag = new ShoppingBag(true);
        for (int i = 3; i >= 0; i--) {
            comparisonBag.putIn(items[i]);
        }
        println(shoppingBag.equals(comparisonBag));
        comparisonBag.remove(ProductType.BREAD);
        println(shoppingBag.equals(comparisonBag));

        // TEST getTotalWeight()

        println(shoppingBag.getTotalWeight());
    }
}
