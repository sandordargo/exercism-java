import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdargo on 05/07/16.
 */
public class Scrabble {
  private String word;

  Scrabble(String input_word) {
    this.word = cleanse(input_word);
  }

  static private Map<Character, Integer> characterValueMap;

  static {
    Map<Character, Integer> aCharacterValueMap = new HashMap<>();
    aCharacterValueMap.put('A', 1);
    aCharacterValueMap.put('E', 1);
    aCharacterValueMap.put('I', 1);
    aCharacterValueMap.put('O', 1);
    aCharacterValueMap.put('U', 1);
    aCharacterValueMap.put('L', 1);
    aCharacterValueMap.put('N', 1);
    aCharacterValueMap.put('R', 1);
    aCharacterValueMap.put('S', 1);
    aCharacterValueMap.put('T', 1);
    aCharacterValueMap.put('D', 2);
    aCharacterValueMap.put('G', 2);
    aCharacterValueMap.put('B', 3);
    aCharacterValueMap.put('C', 3);
    aCharacterValueMap.put('M', 3);
    aCharacterValueMap.put('P', 3);
    aCharacterValueMap.put('F', 4);
    aCharacterValueMap.put('H', 4);
    aCharacterValueMap.put('V', 4);
    aCharacterValueMap.put('W', 4);
    aCharacterValueMap.put('Y', 4);
    aCharacterValueMap.put('K', 5);
    aCharacterValueMap.put('J', 8);
    aCharacterValueMap.put('X', 8);
    aCharacterValueMap.put('Q', 10);
    aCharacterValueMap.put('Z', 10);
    Scrabble.characterValueMap = Collections.unmodifiableMap(aCharacterValueMap);
  }

  public int getScore() {
    int score = 0;
    for (Character character : this.word.toCharArray()) {
      score += Scrabble.characterValueMap.get(character);
    }
    return score;
  }

  private String cleanse(String dirtyWord) {
    if (dirtyWord == null) { return ""; }
    return dirtyWord.replaceAll("[^a-zA-Z]", "").toUpperCase();
  }
}
