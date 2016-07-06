import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

  private String base_word;

  Anagram (String base_word) {
    this.base_word = base_word;
  }

  public List<String> match(List<String> listToCheck) {
    List<String> matchedWords = listToCheck.stream().filter(word -> matchWord(word)).collect(Collectors.toList());
    return matchedWords;
  }

  private boolean matchWord(String word) {
    if (areLengthsEqual(this.base_word, word) || areSameStrings(this.base_word, word)) {
      return false;
    }

    String sorted_base = sortAndLowerString(this.base_word);
    String sorted_word = sortAndLowerString(word);

    for (int i=0; i < sorted_base.length(); i++) {
      if (sorted_base.charAt(i) != sorted_word.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private String sortAndLowerString(String input) {
    char[] charactersArray = input.toLowerCase().toCharArray();
    Arrays.sort(charactersArray);
    return String.valueOf(charactersArray);
  }

  private boolean areLengthsEqual(String leftHandString, String rightHandString) {
    return leftHandString.length() != rightHandString.length();
  }

  private boolean areSameStrings(String leftHandString, String rightHandString) {
    return leftHandString.toUpperCase().equals(rightHandString.toUpperCase());
  }
}
