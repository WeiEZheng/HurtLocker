import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GroceryBuilderTest extends TestCase {
    String name = "Milk";
    String price = "3.33";
    String type = "Food";
    String expirationDate = "5/5/2020";

    public void testBuild() {
        GroceryBuilder groceryBuilder = new GroceryBuilder();
        Grocery grocery = groceryBuilder.setName(name)
                .setPrice(price)
                .setExpirationDate(expirationDate)
                .setType(type).build();
        String actualName = grocery.getName();
        String actualPrice = grocery.getPrice();
        String actualType = grocery.getType();
        String actualExpirationDate = grocery.getExpirationDate();
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(price, actualPrice);
        Assert.assertEquals(type, actualType);
        Assert.assertEquals(expirationDate, actualExpirationDate);
    }

    public void testTestBuild() {
        JerkParser jerkParser = new JerkParser();
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:3.23;type:Food^expiration:1/04/2016" +
                "##naMe:Milk2;price:3.24;type:Food^expiration:1/04/2016");
        List<Map<String,String>> actual = jerkParser.splitAndGet(jerkSON,
                "name", "price", "type", "expiration");
        GroceryBuilder groceryBuilder = new GroceryBuilder();
        Grocery[] groceries= groceryBuilder.build(actual);
        Grocery grocery = groceries[0];
        String actualName = grocery.getName();
        String actualPrice = grocery.getPrice();
        String actualType = grocery.getType();
        String actualExpirationDate = grocery.getExpirationDate();
        Assert.assertEquals("Milk", actualName);
        Assert.assertEquals("3.23", actualPrice);
        Assert.assertEquals("Food", actualType);
        Assert.assertEquals("1/04/2016", actualExpirationDate);
    }
}