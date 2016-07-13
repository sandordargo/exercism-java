/**
 * Created by sdargo on 13/07/16.
 */
public class Binary {
  private String binary;

  public Binary(String input) {
    this.binary = input;
  }

  public int getDecimal() {
    if (!this.isValid()) {
      return 0;
    }
    return computeDeciamal();
  }

  private boolean isValid() {
    for (Character character : this.binary.toCharArray()) {
      if (!character.equals('0') && !character.equals('1')) {
        return false;
      }
    }
    return true;
  }

  private int computeDeciamal() {
    int decimal = 0;
    int lastCharacterPosition = this.binary.length() - 1;
    for (int position = lastCharacterPosition; position >= 0; position--) {
      decimal += Character.getNumericValue(this.binary.charAt(position)) * Math.pow(2, lastCharacterPosition - position);
    }
    return decimal;
  }
}
