import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class JerkParserTest extends TestCase {
    JerkParser jerkParser = new JerkParser();

    public void testSplit() {
        String string = "this is a string";
        JerkSON jerkSON = new JerkSON(string+"##"+string);
        Assert.assertEquals(string, jerkParser.split(jerkSON)[0]);
        Assert.assertEquals(string, jerkParser.split(jerkSON)[1]);
    }

    public void testGet() {
        JerkSON jerkSON = new JerkSON("naMe:;price:3.23;type:Food^expiration:1/04/2016");
        Assert.assertTrue("".equalsIgnoreCase(jerkParser.get(jerkSON.getJerkString(),"name")));
    }

    public void testGetMultiple() {
        JerkSON jerkSON = new JerkSON("naMe:;price:3.23;type:Food^expiration:1/04/2016");
        Assert.assertTrue("".equalsIgnoreCase(jerkParser.get(jerkSON.getJerkString(),"name", "price")[0]));
        Assert.assertTrue("3.23".equalsIgnoreCase(jerkParser.get(jerkSON.getJerkString(),"name", "price")[1]));
    }

    public void testSplitAndGet(){
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:3.23;type:Food^expiration:1/04/2016" +
                "##naMe:Milk2;price:3.24;type:Food^expiration:1/04/2016");
        List<String[]> actual = jerkParser.splitAndGet(jerkSON, "name", "price");
        Assert.assertTrue("Milk".equalsIgnoreCase(actual.get(0)[0]));
        Assert.assertTrue("3.23".equalsIgnoreCase(actual.get(0)[1]));
        Assert.assertTrue("Milk2".equalsIgnoreCase(actual.get(1)[0]));
        Assert.assertTrue("3.24".equalsIgnoreCase(actual.get(1)[1]));
    }
}