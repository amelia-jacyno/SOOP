package classes.class07;

public class Item {
    private static final int minQuantity = 1, maxQuantity = 20;
    private ProductType type;
    private int quantity = 1;
    private String comment = "";

    public Item(ProductType type, int quantity, String comment) {
        this.type = type;
        if (isQuantityValid(quantity)) this.quantity = quantity;
        this.comment = comment;
    }

    public Item(ProductType type, int quantity) {
        this.type = type;
        if (isQuantityValid(quantity)) this.quantity = quantity;
    }

    public Item(ProductType type) {
        this.type = type;
    }

    private boolean isQuantityValid(int quantity) {
        return quantity >= minQuantity && quantity <= maxQuantity;
    }
}
