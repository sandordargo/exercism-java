import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sdargo on 22/07/16.
 */
public class PigLatin {

  public static String translate(String input) {
    String translation = new String();
    for (String word : input.split("\\s+")) {
      translation += PigLatin.translateWord(word) + " ";
    }
    return translation.trim();
  }

  private static String translateWord(String word) {
    String translation = word;
    if (Pattern.compile("([aeiou]|xr|yt){1}.*").matcher(translation).matches()) {
      return translation + "ay";
    }

    Matcher matcher = Pattern.compile("(ch|qu|thr|th|sch|.qu|[qwrtypsdfghjklzxcvbnm]){1}.*").matcher(translation);
    if (matcher.matches()) {
      return translation.substring(matcher.group(1).length()) + matcher.group(1) + "ay";
    }

    return translation;
  }
}
