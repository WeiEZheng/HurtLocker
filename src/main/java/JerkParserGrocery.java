import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkParserGrocery extends JerkParser<Grocery>{

    public String doEverything(JerkSON jerkSON){
        Grocery[] groceries= buildToObj(new GroceryBuilder(),
                splitAndGet(jerkSON, "name", "price", "type", "expiration"));
        return tabulate(groceries);
    }

    public String tabulate(Grocery[] groceries){
        Integer error = 0;
        Set<String> seenName = new TreeSet<>();
        Set<String> seenPrice = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> prices = new HashMap<>();
        for (int i = 0; i < groceries.length; i++){
            if (groceries[i].isNull()){
                error++;
            }
            else{
                String name = correctName(groceries[i].getName());
                if (seenName.add(name)) {
                    count.put(name, 1);
                    count.put(name+"#"+groceries[i].getPrice(), 1);
                    seenPrice.add(name+"#"+groceries[i].getPrice());
                    List<String> tempList = new ArrayList<>();
                    tempList.add(groceries[i].getPrice());
                    prices.put(name, tempList);
                }else {
                    count.put(name, count.get(name)+1);
                    if (seenPrice.add(name+"#"+groceries[i].getPrice())) {
                        count.put(name+"#"+groceries[i].getPrice(), 1);
                        List<String> tempList = prices.get(name);
                        tempList.add(groceries[i].getPrice());
                        prices.put(name, tempList);
                    }
                    else {
                        count.put(name + "#" + groceries[i].getPrice(),
                                count.get(name + "#" + groceries[i].getPrice()) + 1);
                    }
                }
            }
        }
        String result = "";
        for (String s: seenName) {
            result+=printWithFormat(s, prices.get(s), count);
        }
        result +=String.format("%-15s%10s: %d times\n", "Errors", "Seen", error);
        //using string.format rather than system.out.printf to better automate test
        return result;
    }

    public String printWithFormat(String name, List<String> prices, Map<String, Integer> count) {
        String doubleLine = "=============";
        String line = "-------------";
        String result = "";
        result +=String.format("Name:%8s%13s: %s times\n", name, "Seen", count.get(name));
        result +=String.format("%s%9s%s\n", doubleLine, "", doubleLine);
        for (String price: prices) {
            result +=String.format("Price:%7s%13s: %s times\n", price, "Seen", count.get(name+"#"+price));
            result +=String.format("%s%9s%s\n", line, "", line);
        }
        result+="\n";
        return result;
    }

    public String correctName(String name) {
        Pattern milk = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher match = milk.matcher(name);
        if(match.find())
            return "Milk";
        Pattern bread = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
        match = bread.matcher(name);
        if(match.find())
            return "Bread";
        Pattern cookies = Pattern.compile("c..kies", Pattern.CASE_INSENSITIVE);
        match = cookies.matcher(name);
        if(match.find())
            return "Cookies";
        Pattern apple = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
        match = apple.matcher(name);
        if(match.find())
            return "Apples";
        return name;
    }
}
