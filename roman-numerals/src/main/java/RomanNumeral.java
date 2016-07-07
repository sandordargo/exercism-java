import javafx.util.Pair;

import java.util.*;

/**
 * Created by sdargo on 07/07/16.
 */
public class RomanNumeral {
  private int arabicNumber;
  static Map<Integer, String> arabicRomanMap = new TreeMap<>(Collections.reverseOrder());

  static {
    arabicRomanMap.put(1000, "M");
    arabicRomanMap.put(500, "D");
    arabicRomanMap.put(100, "C");
    arabicRomanMap.put(50, "L");
    arabicRomanMap.put(10, "X");
    arabicRomanMap.put(5, "V");
    arabicRomanMap.put(1, "I");
  }

  public RomanNumeral(int arabicNumber) {
    this.arabicNumber = arabicNumber;
  }

  public String getRomanNumeral() {
    String roman = "";
    Pair<String, Integer> resultPair = new Pair<>("", this.arabicNumber);
    for (Map.Entry<Integer, String> entry : RomanNumeral.arabicRomanMap.entrySet()) {
      System.out.println(entry.getKey());
      resultPair = getPart(resultPair.getValue(), entry.getKey(), entry.getValue());
      roman += resultPair.getKey();
    }
    return roman;
  }

  private Pair<String, Integer> getPart(int input, int divider, String roman) {
    String output = "";
    int residual = input;
    int times = residual / divider;

    residual = residual % divider;
    if (times == 1 && ((residual + 1) / divider == 1) && divider == 5) {
      output += "IX";
      residual -= 4;
    } else if (times == 1 && ((residual + 10) / divider == 1) && divider == 50) {
      output += "XC";
      residual -= 40;
    } else if (times == 1 && ((residual + 100) / divider == 1) && divider == 500) {
      output += "CM";
      residual -= 400;
    } else {

      if (divider == 100 && times == 4) {
        output += "CD";
      } else if (divider == 10 && times == 4) {
        output += "XL";
      } else if (divider == 1 && times == 4) {
        output += "IV";
      } else {
        for (int i = 0; i < times; i++) {
          output += roman;
        }
      }
    }
    return new Pair<>(output, residual);
  }
}
