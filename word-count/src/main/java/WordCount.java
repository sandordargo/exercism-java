import java.util.HashMap;
import java.util.Map;

public class WordCount {

  public Map<String, Integer> phrase(String input_phrase) {
    Map<String, Integer> word_occurrence_map = new HashMap<>();
    String[] words = input_phrase.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
    for (String word : words) {
      if (word != null && word_occurrence_map.containsKey(word)) {
        word_occurrence_map.replace(word, word_occurrence_map.get(word) + 1);
      } else {
        word_occurrence_map.put(word, 1);
      }
    }
    return word_occurrence_map;
  }

}
