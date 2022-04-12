import junit.framework.TestCase;
import org.junit.Assert;

public class GroceryTest extends TestCase {
    String name = "Milk";
    String price = "3.33";
    String type = "Food";
    String expirationDate = "5/5/2020";


    public void testGet() {
        Grocery grocery = new Grocery(name, price, type, expirationDate);
        String actualName = grocery.getName();
        String actualPrice = grocery.getPrice();
        String actualType = grocery.getType();
        String actualExpirationDate = grocery.getExpirationDate();
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(price, actualPrice);
        Assert.assertEquals(type, actualType);
        Assert.assertEquals(expirationDate, actualExpirationDate);
    }

    public void testIsNull() {
        Grocery grocery = new Grocery("", price, type, expirationDate);
        Assert.assertTrue(grocery.isNull());
    }
}