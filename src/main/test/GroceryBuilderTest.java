import junit.framework.TestCase;
import org.junit.Assert;

public class GroceryBuilderTest extends TestCase {
    String name = "Milk";
    Double price = 3.33;
    String type = "Food";
    String expirationDate = "5/5/2020";

    public void testBuild() {
        GroceryBuilder groceryBuilder = new GroceryBuilder();
        Grocery grocery = groceryBuilder.setName(name)
                .setPrice(price)
                .setExpirationDate(expirationDate)
                .setType(type).build();
        String actualName = grocery.getName();
        Double actualPrice = grocery.getPrice();
        String actualType = grocery.getType();
        String actualExpirationDate = grocery.getExpirationDate();
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(price, actualPrice);
        Assert.assertEquals(type, actualType);
        Assert.assertEquals(expirationDate, actualExpirationDate);
    }
}