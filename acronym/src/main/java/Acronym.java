import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sdargo on 06/07/16.
 */
public class Acronym {
  public static String generate(String phrase) {
    String acronym = new String();
    phrase = phrase.replaceAll("-", " ");
    phrase = splitWhereLowerUpper(phrase);

    for (String word : new ArrayList<>(Arrays.asList(phrase.split(" ")))) {
      acronym += word.substring(0,1).toUpperCase();
    }
    return acronym;
  }

  static private String splitWhereLowerUpper(String phraseToSplit) {
    Pattern lowerUpperPattern = Pattern.compile(".*([a-z]{1})([A-Z]{1}).*");
    Matcher matcher = lowerUpperPattern.matcher(phraseToSplit);
    if (matcher.matches()) {
      return phraseToSplit.replace(matcher.group(1) + matcher.group(2), matcher.group(1) + " " + matcher.group(2));
    }
    return phraseToSplit;
  }
}
