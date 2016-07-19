import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdargo on 19/07/16.
 */
public class Luhn {

  long number;
  List<Integer> addends = new ArrayList<>();
  int checksum;

  public Luhn(long number) {
    this.number = number;
    this.addends = calculateAddends();
    this.checksum = calculateCheckSum();
  }

  public int getCheckDigit() {
    return (int) this.number % 10;
  }

  public int[] getAddends() {
    return this.addends.stream().mapToInt(i->i).toArray();
  }

  public int getCheckSum() {
    return this.checksum;
  }

  public boolean isValid() {
    return getCheckSum() % 10 == 0;
  }

  public static long create(long input) {
    int checkSum = 0;
    long numberCopy = input;
    int counter = 0;
    while (numberCopy > 0) {
      int digit = (int) numberCopy % 10;
      numberCopy /= 10;
      if (counter % 2 == 0) {
        digit *= 2;
        if (digit > 9) {
          digit -= 9;
        }
      }
      checkSum += digit;
      counter++;
    }
    int missingDigit = (10 - (checkSum % 10)) % 10;
    return Long.valueOf(String.valueOf(input) + String.valueOf(missingDigit));
  }

  private List<Integer> calculateAddends () {
    List<Integer> addends = new ArrayList<>();
    long numberCopy = this.number;
    int counter = 1;
    while (numberCopy > 0) {
      int digit = (int) numberCopy % 10;
      numberCopy /= 10;
      if (counter % 2 == 0) {
        digit *= 2;
        if (digit > 9) {
          digit -= 9;
        }
      }
      addends.add(0, digit);
      counter++;
    }
    return addends;
  }

  private int calculateCheckSum() {
    int checkSum = 0;
    for (Integer digit : addends) {
      checkSum += digit;
    }
    return checkSum;
  }

}
