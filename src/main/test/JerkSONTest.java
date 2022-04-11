import junit.framework.TestCase;
import org.junit.Assert;

public class JerkSONTest extends TestCase {

    public void testGetJerkString() {
        String string = "this is a string";
        JerkSON jerkSON = new JerkSON(string);
        Assert.assertEquals(string, jerkSON.getJerkString());
    }
}