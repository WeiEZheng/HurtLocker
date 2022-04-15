import junit.framework.TestCase;
import org.junit.Assert;

public class JerkParserGroceryTest extends TestCase {
    JerkParserGrocery jerkParserGrocery = new JerkParserGrocery();

    public void testDoEverything() {
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:3.23;type:Food^expiration:1/04/2016" +
                "##naMe:Milk;price:3.23;type:Food^expiration:1/04/2016" +
                "##naMe:Milk;price:3.24;type:Food^expiration:1/04/2016" +
                "##naMe:;price:3.23;type:Food^expiration:1/04/2016");
        String actual = jerkParserGrocery.doEverything(jerkSON);
        String expected = "";
        String doubleLine = "=============";
        String line = "-------------";
        expected +=String.format("Name:%8s%13s: %s times\n", "Milk", "Seen", 3);
        expected +=String.format("%s%9s%s\n", doubleLine, "", doubleLine);
        expected +=String.format("Price:%7s%13s: %s times\n", "3.23", "Seen", 2);
        expected +=String.format("%s%9s%s\n", line, "", line);
        expected +=String.format("Price:%7s%13s: %s times\n", "3.24", "Seen", 1);
        expected +=String.format("%s%9s%s\n", line, "", line);
        expected+="\n";
        expected +=String.format("%-15s%10s: %d times\n", "Errors", "Seen", 1);
        Assert.assertEquals(expected, actual);
    }

    public void testCorrectName() {
        String wrongName = "Co1kies";
        String actualCorrected = jerkParserGrocery.correctName(wrongName);
        Assert.assertEquals("Cookies", actualCorrected);
    }
    public void testCorrectName1() {
        String wrongName = "bread";
        String actualCorrected = jerkParserGrocery.correctName(wrongName);
        Assert.assertEquals("Bread", actualCorrected);
    }    public void testCorrectName2() {
        String wrongName = "milk";
        String actualCorrected = jerkParserGrocery.correctName(wrongName);
        Assert.assertEquals("Milk", actualCorrected);
    }
    public void testCorrectName3() {
        String wrongName = "apples";
        String actualCorrected = jerkParserGrocery.correctName(wrongName);
        Assert.assertEquals("Apples", actualCorrected);
    }
    public void testCorrectName4() {
        String wrongName = "Cola";
        String actualCorrected = jerkParserGrocery.correctName(wrongName);
        Assert.assertEquals("Cola", actualCorrected);
    }
}