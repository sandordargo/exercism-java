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
      resultPair = getPart(resultPair.getValue(), new Pair<Integer, String>(entry.getKey(), entry.getValue()));
      roman += resultPair.getKey();
    }
    return roman;
  }

  private Pair<String, Integer> getPart(int input, Pair<Integer, String> arabicRomanPair) {
    String output = "";
    int divider = arabicRomanPair.getKey();
    int residual = input;
    int times = residual / divider;

    residual = residual % divider;
    if (isDivider5or50or500(divider) && times == 1 && ((residual + divider / 5) / divider == 1)) {
      residual -= (divider / 5) * 4;
      output += RomanNumeral.arabicRomanMap.get(divider / 5) + RomanNumeral.arabicRomanMap.get(divider * 2);
    } else if (isDivider1or10or100(divider) && times == 4) {
        output += RomanNumeral.arabicRomanMap.get(divider) + RomanNumeral.arabicRomanMap.get(5 * divider);
    } else {
        for (int i = 0; i < times; i++) {
          output += arabicRomanPair.getValue();
      }
    }
    return new Pair<>(output, residual);
  }

  private boolean isDivider5or50or500(int divider) {
    return (divider == 5 || divider == 50 || divider == 500);
  }

  private boolean isDivider1or10or100(int divider) {
    return (divider == 1 || divider == 10 || divider == 100);
  }

}
