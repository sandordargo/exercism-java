import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sdargo on 18/07/16.
 */
public class Trinary {

  public static int toDecimal(String input) {
    if (!Trinary.isTrinary(input)) { return 0; }

    int trinaryValue = 0;
    String reversedInput = Trinary.reverse(input);
    for (int position=0; position < reversedInput.length(); position++) {
      trinaryValue += Integer.valueOf(reversedInput.substring(position, position+1)) * (int) Math.pow(3, position);
    }
    return trinaryValue;
  }

  private static String reverse(String input) {
    StringBuffer stringBuffer = new StringBuffer(input);
    return stringBuffer.reverse().toString();
  }

  private static boolean isTrinary(String input) {
    return Pattern.compile("[0-2]*").matcher(input).matches();
  }
}
