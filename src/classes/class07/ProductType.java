package classes.class07;

public enum ProductType {
    BREAD (3.5), MILK(2.2), TEA(15.0), BUTTER(7.5), OTHER(0.0);
    private double weight;
    public static ProductType fromString(String s) {
        s=s.toLowerCase().trim();
        return switch (s) {
            case "bread" -> BREAD;
            case "milk" -> MILK;
            case "tea" -> TEA;
            case "butter" -> BUTTER;
            default -> OTHER;
        };
    }
    ProductType(double weight) {
        this.weight=weight;
    }
    public double getWeihgt() {
        return weight;
    }
    public String show() {
        String s=this + " ["+weight+"]";
        return s.toLowerCase();
    }
    public static void testMe() {
        ProductType p1=ProductType.BREAD;
        System.out.println(p1);
        p1=ProductType.fromString("tea");
        System.out.println(p1);
        for (ProductType p: ProductType.values()) {
            System.out.println(p.show());
        }
    }
}

