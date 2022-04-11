import java.util.List;
import java.util.Map;

public class GroceryBuilder implements Builder<Grocery>{
    private String name = "";
    private String price = "0.00";
    private String type = "";
    private String expirationDate = "";

    public GroceryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GroceryBuilder setPrice(String price) {
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

    @Override
    public Grocery[] build(List<Map<String,String>> itemProperties) {
        Grocery[] groceries = new Grocery[itemProperties.size()];
        for (int i =0; i<itemProperties.size();i++){
            Map <String,String> item= itemProperties.get(i);
            groceries[i]=new Grocery(item.get("name"),item.get("price"), item.get("type"), item.get("expiration"));
        }
        return groceries;
    }

    public Grocery build(){
        return new Grocery(name, price, type, expirationDate);
    }
}
