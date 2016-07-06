import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> transformed_map = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
//            for (String letter : entry.getValue()) {
//                if (transformed_map.get(letter) == null) {
//                    transformed_map.put(letter.toLowerCase(), entry.getKey());
//                }
//            }
            entry.getValue().forEach(letter->{
                if (transformed_map.get(letter) == null) {
                    transformed_map.put(letter.toLowerCase(), entry.getKey());
              }
            });
        }
        return transformed_map;
    }
}
