public class GroceryBuilder {
    private String name = "";
    private Double price = 0.0;
    private String type = "";
    private String expirationDate = "";

    public GroceryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GroceryBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public GroceryBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public GroceryBuilder setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Grocery build(){
        return new Grocery(name, price, type, expirationDate);
    }
}
