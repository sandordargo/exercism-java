import java.util.regex.Pattern;

/**
 * Created by sdargo on 20/07/16.
 */
public class Octal {

  private String octal;
  private int decimal;

  public Octal(String octal) {
    this.octal = octal;
    this.decimal = this.toDecimal();
  }

  public int getDecimal() {
    return this.decimal;
  }

  private int toDecimal() {
    if (!this.validate()) {
      return 0;
    }
    String reversed = this.reverse();
    int decimalvalue = 0;
    for (int position=0; position < reversed.length(); position++) {
      decimalvalue += Integer.valueOf(reversed.substring(position, position + 1)) * (int) Math.pow(8, position);
    }
    return decimalvalue;
  }

  private String reverse() {
    StringBuffer stringBuffer = new StringBuffer(this.octal);
    return stringBuffer.reverse().toString().toLowerCase();
  }

  private boolean validate() {
    return (Pattern.compile("[0-7]*").matcher(this.octal).matches());
  }
}
