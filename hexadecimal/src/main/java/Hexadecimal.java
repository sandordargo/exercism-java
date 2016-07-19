import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by sdargo on 19/07/16.
 */
public class Hexadecimal {

  public static int toDecimal(String hexaString) {
    if (!Hexadecimal.validate(hexaString)) {
      return 0;
    }
    String reversed = Hexadecimal.reverse(hexaString);
    int decimalvalue = 0;
    for (int position=0; position < reversed.length(); position++) {
      decimalvalue += Hexadecimal.decimalOfHexaDigit(reversed.charAt(position)) * (int) Math.pow(16, position);
    }
    return decimalvalue;
  }

  private static String reverse(String input) {
    StringBuffer stringBuffer = new StringBuffer(input);
    return stringBuffer.reverse().toString().toLowerCase();
  }

//  private static int decimalOfHexaDigit(Character digit) {
//    Map<Character, Integer> hexaDecimalMap = new HashMap<>();
//    hexaDecimalMap.put('0', 0);
//    hexaDecimalMap.put('1', 1);
//    hexaDecimalMap.put('2', 2);
//    hexaDecimalMap.put('3', 3);
//    hexaDecimalMap.put('4', 4);
//    hexaDecimalMap.put('5', 5);
//    hexaDecimalMap.put('6', 6);
//    hexaDecimalMap.put('7', 7);
//    hexaDecimalMap.put('8', 8);
//    hexaDecimalMap.put('9', 9);
//    hexaDecimalMap.put('a', 10);
//    hexaDecimalMap.put('b', 11);
//    hexaDecimalMap.put('c', 12);
//    hexaDecimalMap.put('d', 13);
//    hexaDecimalMap.put('e', 14);
//    hexaDecimalMap.put('f', 15);
//
//    return hexaDecimalMap.get(digit);
//  }

  private static int decimalOfHexaDigit(Character digit) {
    return "0123456789abcdef".indexOf(digit);
  }

  private static boolean validate(String candidate) {
    return (Pattern.compile("[0-9a-fA-F]*").matcher(candidate).matches());
  }
}
