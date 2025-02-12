import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JerkSON jerkSON = new JerkSON(output);
        JerkParserGrocery jerkParserGrocery = new JerkParserGrocery();
        System.out.print(jerkParserGrocery.doEverything(jerkSON));
    }
}
