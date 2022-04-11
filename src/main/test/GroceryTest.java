import junit.framework.TestCase;
import org.junit.Assert;

public class GroceryTest extends TestCase {
    String name = "Milk";
    Double price = 3.33;
    String type = "Food";
    String expirationDate = "5/5/2020";


    public void testGet() {
        Grocery grocery = new Grocery(name, price, type, expirationDate);
        String actualName = grocery.getName();
        Double actualPrice = grocery.getPrice();
        String actualType = grocery.getType();
        String actualExpirationDate = grocery.getExpirationDate();
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(price, actualPrice);
        Assert.assertEquals(type, actualType);
        Assert.assertEquals(expirationDate, actualExpirationDate);
    }

    public void testTestToString() {
        Grocery grocery = new Grocery(name, price, type, expirationDate);
        String actualOutput =  grocery.toString();
        String expected = "Grocery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Type='" + type + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
        Assert.assertEquals(expected, actualOutput);
    }

    public void testTestEquals() {
        Grocery grocery = new Grocery(name, price, type, expirationDate);
        Grocery grocery1 = new Grocery(name, price, type, expirationDate);
        Assert.assertEquals(grocery,grocery1);
    }
}