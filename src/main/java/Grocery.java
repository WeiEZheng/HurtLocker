public class Grocery {
    private String name;
    private Double price;
    private String type;
    private String expirationDate;

    public Grocery(String name, Double price, String type, String expirationDate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Type='" + type + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
