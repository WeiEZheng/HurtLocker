import java.util.List;
import java.util.Map;

public interface Builder<T> {
    T[] build(List<Map<String,String>> itemProperties);
}
