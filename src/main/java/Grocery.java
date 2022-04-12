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

    public boolean isNull(){
        if (name.equals("") | price.equals("0.00") | price.equals("") | type.equals("")| expirationDate.equals(""))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
