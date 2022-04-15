import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JerkParserTest extends TestCase {
    JerkParser jerkParser = new JerkParser();

    public void testSplit() {
        String string = "this is a string";
        JerkSON jerkSON = new JerkSON(string+"##"+string);
        Assert.assertEquals(string, jerkParser.split(jerkSON)[0]);
        Assert.assertEquals(string, jerkParser.split(jerkSON)[1]);
    }

    public void testGet() throws ItemException {
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:3.23;type:Food^expiration:1/04/2016");
        Assert.assertTrue("Milk".equalsIgnoreCase(jerkParser.get(jerkSON.getJerkString(),"name")));
    }

    public void testGetMultipleFields() throws ItemException {
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:3.23;type:Food^expiration:1/04/2016");
        Map<String,String> actual = jerkParser.get(jerkSON.getJerkString(), "name", "price");
        Assert.assertTrue("Milk".equalsIgnoreCase(actual.get("name")));
        Assert.assertTrue("3.23".equalsIgnoreCase(actual.get("price")));
    }

    @Test(expected = ItemException.class)
    public void testGetMultipleException(){
        JerkSON jerkSON = new JerkSON("naMe:;price:3.23;type:Food^expiration:1/04/2016");
        try {
            Map<String,String> actual = jerkParser.get(jerkSON.getJerkString(), "name", "price");
        } catch (ItemException e) {
        }
    }
    @Test(expected = ItemException.class)
    public void testGetMultipleException1(){
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:;type:Food^expiration:1/04/2016");
        try {
            Map<String,String> actual = jerkParser.get(jerkSON.getJerkString(), "name", "price");
        } catch (ItemException e) {
        }
    }
    @Test(expected = ItemException.class)
    public void testGetMultipleException2(){
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:2;type:^expiration:1/04/2016");
        try {
            Map<String,String> actual = jerkParser.get(jerkSON.getJerkString(), "name", "price");
        } catch (ItemException e) {
        }
    }
    @Test(expected = ItemException.class)
    public void testGetMultipleException3(){
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:2;type:Food^expiration:");
        try {
            Map<String,String> actual = jerkParser.get(jerkSON.getJerkString(), "name", "price");
        } catch (ItemException e) {
        }
    }

    public void testSplitAndGet(){
        JerkSON jerkSON = new JerkSON("naMe:Milk;price:3.23;type:Food^expiration:1/04/2016" +
                "##naMe:Milk2;price:3.24;type:Food^expiration:1/04/2016");
        List<Map<String,String>> actual = jerkParser.splitAndGet(jerkSON, "name", "price");
        Assert.assertTrue("Milk".equalsIgnoreCase(actual.get(0).get("name")));
        Assert.assertTrue("3.23".equalsIgnoreCase(actual.get(0).get("price")));
        Assert.assertTrue("Milk2".equalsIgnoreCase(actual.get(1).get("name")));
        Assert.assertTrue("3.24".equalsIgnoreCase(actual.get(1).get("price")));
    }

    public void testGet1() throws ItemException {
        JerkSON jerkSON = new JerkSON("naMe:Milk2;price:3.23;type:Food^expiration:1/04/2016");
        Assert.assertTrue("Milk2".equalsIgnoreCase(jerkParser.get(jerkSON.getJerkString(),"name")));
    }
}