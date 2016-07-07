import javafx.util.Pair;

import java.util.StringTokenizer;

/**
 * Created by sdargo on 07/07/16.
 */
public class RomanNumeral {
  private int arabicNumber;

  public RomanNumeral(int arabicNumber) {
    this.arabicNumber = arabicNumber;
  }

  public String getRomanNumeral() {
    String roman = "";
    Pair<String, Integer> resultPair = getPart(this.arabicNumber, 1000, "M");
    roman += resultPair.getKey();
    resultPair = getPart(resultPair.getValue(), 500, "D");
    roman += resultPair.getKey();
    resultPair = getPart(resultPair.getValue(), 100, "C");
    roman += resultPair.getKey();
    resultPair = getPart(resultPair.getValue(), 50, "L");
    roman += resultPair.getKey();
    resultPair = getPart(resultPair.getValue(), 10, "X");
    roman += resultPair.getKey();
    resultPair = getPart(resultPair.getValue(), 5, "V");
    roman += resultPair.getKey();
    resultPair = getPart(resultPair.getValue(), 1, "I");
    roman += resultPair.getKey();
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
