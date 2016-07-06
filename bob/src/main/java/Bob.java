/**
 * Created by sdargo on 03/07/16.
 */
public class Bob {
  public String hey(String phrase) {
    if (phrase.replaceAll("\\s+", "").isEmpty()) {return "Fine. Be that way!";}
    if (isYelling(phrase)) {return "Whoa, chill out!";}
    if (phrase.charAt(phrase.length() - 1) == '?') {
      return  "Sure.";
    }


    return "Whatever.";
  }

  private boolean isYelling(String phrase) {
    if (phrase.equals(phrase.toUpperCase()) && isAlpha(phrase)) {
      return true;
    }
    return false;
  }

  public boolean isAlpha(String phrase) {
    return phrase.matches(".*[a-zA-Z]+.*");
  }

}
