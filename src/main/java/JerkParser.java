import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkParser<T> {

    public List<Map<String,String>> splitAndGet(JerkSON jerkSON, String ... fieldNames){
        String[] jerkSONStrings = split(jerkSON);
        List<Map<String,String>> result = new ArrayList<>();
        for (int i=0; i< jerkSONStrings.length;i++){
            result.add(get(jerkSONStrings[i],fieldNames));
        }
        return result;
    }

    public String[] split (JerkSON jerkSON){
        Pattern pattern = Pattern.compile("(?<=##|^).*?(?=##|$)");
        Matcher matcher = pattern.matcher(jerkSON.getJerkString());
        Integer count = 0;
        List<String> result = new ArrayList<>();
        while (matcher.find()){
            if (!matcher.group().equals("")) {
                result.add(matcher.group());
                count++;
            }
        }
        return result.toArray(new String[count]);
//        return pattern.split(jerkSON.getJerkString());
    }

    public Map<String,String> get(String jerkSONString, String ... fieldNames){
        String[] fields = fieldNames;
        Map<String,String> result = new HashMap<>();
        for (int i = 0; i<fields.length; i++) {
            result.put(fields[i],get(jerkSONString, fields[i]));
        }
        return result;
    }

    public String get(String jerkSONString, String fieldName){
        Pattern pattern = Pattern.compile("(?<="+fieldName+"[;:%@*^]).*?(?=[;:%@*^]|$)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkSONString);
        if (matcher.find()){
            return matcher.group();
        }
        return "";
    }

    public T[] buildToObj(Builder<T> builder, List<Map<String,String>> itemProperties){
        return builder.build(itemProperties);
    }
}
