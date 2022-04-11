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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grocery grocery = (Grocery) o;

        if (name != null ? !name.equals(grocery.name) : grocery.name != null) return false;
        if (price != null ? !price.equals(grocery.price) : grocery.price != null) return false;
        if (type != null ? !type.equals(grocery.type) : grocery.type != null) return false;
        return expirationDate != null ? expirationDate.equals(grocery.expirationDate) : grocery.expirationDate == null;
    }
}
