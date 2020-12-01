package labs.lab07;

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

    public int getQuantity() {
        return quantity;
    }

    public ProductType getType() {
        return type;
    }

    private boolean isQuantityValid(int quantity) {
        return quantity >= minQuantity && quantity <= maxQuantity;
    }

    public boolean addItem() {
        if (quantity < maxQuantity) {
            quantity++;
            return true;
        }
        return false;
    }

    public boolean addItems(int count) {
        if (quantity + count > maxQuantity) return false;
        quantity += count;
        return true;
    }

    public boolean removeItems(int count) {
        if (quantity - count < minQuantity) return false;
        quantity -= count;
        return true;
    }

    public double getTotalWeight() {
        return type.getWeight() * quantity;
    }

    public boolean equals(Item item) {
        return quantity == item.quantity && type == item.type;
    }

    @Override
    public String toString() {
        return "{ type: " + type + ", quantity: " + quantity + ", comment: \"" + comment + "\" }";
    }
}
