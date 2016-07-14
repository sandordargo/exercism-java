/**
 * Created by sdargo on 14/07/16.
 */
public class Raindrops {
  public static String convert(int input) {
    String converted = "";
    converted += convertIfDividable(input, 3, "Pling");
    converted += convertIfDividable(input, 5, "Plang");
    converted += convertIfDividable(input, 7, "Plong");
    if (converted.isEmpty()) {
      return String.valueOf(input);
    }
    return converted;
  }

  private static String convertIfDividable(int input, int divider, String converted) {
    if (input % divider == 0) {
      return converted;
    }
    return "";
  }
}