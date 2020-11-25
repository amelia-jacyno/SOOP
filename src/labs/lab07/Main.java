package labs.lab07;

import static labs.lab07.ProductType.*;
import static helpers.ConsoleHelper.*;

public class Main {
    public static void main(String[] args) {
        ProductType.testMe();
        Item[] startingItems = {
                new Item(BREAD, 7, "I like bread"),
                new Item(BUTTER, 2),
                new Item(TEA)
        };
        Item[] items = new Item[3];
        System.arraycopy(startingItems, 0, items, 0, items.length);

        println("Print both arrays:");
        printArr(startingItems);
        printArr(items);
        println();

        println("Print quantity and total weight of each item:");
        for (Item item : items) {
            println("Total weight: " + item.getTotalWeight() + ", Quantity: " + item.getQuantity());
        }
        println();

        println("Increase quantity by one in each item object:");
        for (Item item : items) {
            println(item.addItem() + " " + item);
        }
        println();

        println("Increase quantity by five in each item object:");
        for (Item item : items) {
            println(item.addItems(5) + " " + item);
        }
        println();

        println("Decrease quantity by 3 in each item object:");
        for (Item item : items) {
            println(item.removeItems(3) + " " + item);
        }
        println();

        println("Try to increase quantity by 13 in each item object");
        for (Item item : items) {
            println(item.addItems(13) + " " + item);
        }
        println();

        println("Try to decrease quantity by 17 in each item object");
        for (Item item : items) {
            println(item.removeItems(17) + " " + item);
        }
        println();

        println("Try to create items with unacceptable value:");
        Item testItem = new Item(BREAD, -7);
        println(testItem);
        println();

        println("Compare testItem to items:");
        for (Item item: items) {
            println(testItem + " == " + item + " -> " + testItem.equals(item));
        }
        println();

        println("Compare items to themselves:");
        for (Item item: items) {
            println(item + " == " + item + " -> " + item.equals(item));
        }
        println();

        println("Change quantity of testItem to items[0] and compare them: ");
        testItem.addItems(items[0].getQuantity() - testItem.getQuantity());
        println(testItem + " == " + items[0] + " -> " + testItem.equals(items[0]));
        println();

        // TEST BAD DATA
        // TEST EQUALS
    }
}
