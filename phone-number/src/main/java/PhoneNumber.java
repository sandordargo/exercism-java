/**
 * Created by sdargo on 04/07/16.
 */
public class PhoneNumber {

  private String phoneNumber;
  private final String invalidNumber = "0000000000";

  PhoneNumber(String phoneNumber) {
    phoneNumber = cleanPhoneNumber(phoneNumber);
    if (phoneNumber.length() == 11) {
      if (phoneNumber.charAt(0) == '1') {
        this.phoneNumber = phoneNumber.substring(1, phoneNumber.length());
      } else {
        this.phoneNumber = this.invalidNumber;
      }
    } else if (phoneNumber.length() != 10) {
      this.phoneNumber = this.invalidNumber;
    } else {
      this.phoneNumber = phoneNumber;
    }
  }

  public String getNumber() { return this.phoneNumber; }

  public String getAreaCode() { return this.phoneNumber.substring(0, 3); }

  public String pretty() {
    int firstSectionEndsAt = 3;
    int secondSectionEndsAt = 6;
    return "(" + this.phoneNumber.substring(0, firstSectionEndsAt) + ") " +
            this.phoneNumber.substring(firstSectionEndsAt, secondSectionEndsAt) + "-" +
            this.phoneNumber.substring(secondSectionEndsAt, this.phoneNumber.length());
  }

  private String cleanPhoneNumber(String inputNumber) {
    return inputNumber.replaceAll("[^0-9]", "");
  }

}
