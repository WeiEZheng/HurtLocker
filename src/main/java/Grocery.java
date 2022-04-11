public class Grocery {
    private String name;
    private String price;
    private String type;
    private String expirationDate;

    public Grocery(String name, String price, String type, String expirationDate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
