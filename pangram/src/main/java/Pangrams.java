import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdargo on 02/07/16.
 */
public class Pangrams {
  private static String TEST_PANGRAM = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";

  public static boolean isPangram(String phrase) {
    Map<Character, Boolean> characterBooleanMap = Pangrams.getCharacterBooleanMap();
    String cleanPhrase = phrase.toUpperCase().replaceAll("[^a-zA-Z]", "").replaceAll("\\s+", "");
    if (cleanPhrase.isEmpty()) {
      return false;
    }

    for (Character character : cleanPhrase.toCharArray()) {
      if (!characterBooleanMap.get(character)) {
        characterBooleanMap.replace(character, true);
      }
    }

    return Pangrams.isEveryValueTrue(characterBooleanMap);
  }

  private static java.util.Map<Character, Boolean> getCharacterBooleanMap() {
    Map<Character, Boolean> charterBooleanMap = new HashMap<>();
    for (Character character : Pangrams.TEST_PANGRAM.toCharArray()) {
      charterBooleanMap.put(character, false);
    }
    return charterBooleanMap;
  }

  private static boolean isEveryValueTrue(Map<Character, Boolean> mapToCheck) {
    for (Map.Entry entry : mapToCheck.entrySet()) {
      if (entry.getValue().equals(false)) {
        return false;
      }
    }
    return true;
  }

}
