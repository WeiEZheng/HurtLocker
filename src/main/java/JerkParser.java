import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkParser {

    public List<String[]> splitAndGet(JerkSON jerkSON, String ... fieldNames){
        String[] jerkSONStrings = split(jerkSON);
        List<String[]> result = new ArrayList<>();
        for (int i=0; i< jerkSONStrings.length;i++){
            result.add(get(jerkSONStrings[i],fieldNames));
        }
        return result;
    }

    public String[] split (JerkSON jerkSON){
        Pattern pattern = Pattern.compile("##");
        return pattern.split(jerkSON.getJerkString());
    }

    public String[] get(String jerkSONString, String ... fieldNames){
        String[] fields = fieldNames;
        String[] result = new String[fields.length];
        for (int i = 0; i<fields.length; i++) {
            result[i] = get(jerkSONString, fields[i]);
        }
        return result;
    }

    public String get(String jerkSONString, String fieldName){
        Pattern pattern = Pattern.compile("(?<="+fieldName+"[;:%@*^]).*?(?=[;:%@*^])", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkSONString);
        if (matcher.find()){
            return matcher.group();
        }
        return "";
    }
}
