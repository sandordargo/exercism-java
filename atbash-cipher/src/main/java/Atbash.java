/**
 * Created by sdargo on 15/07/16.
 */
public class Atbash {

  private static String decodedAlphabet;
  private static String encodedAlphabet;

  static {
    Atbash.decodedAlphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    Atbash.encodedAlphabet = "zyxwvutsrqponmlkjihgfedcba0123456789";
  }

  public static String encode(String input) {
    String encodedString = new String();
    input = Atbash.clean(input);
    for (int i=0; i<input.length(); i++) {
      int encodedPosition = decodedAlphabet.indexOf(input.charAt(i));
      encodedString += encodedAlphabet.charAt(encodedPosition);
      if ((i + 1) % 5 == 0) {
        encodedString += " ";
      }
    }
    return encodedString.trim();
  }

  public static String decode(String input) {
    String decodedString = new String();
    input = Atbash.clean(input);
    for (int i=0; i<input.length(); i++) {
      int decodedPosition = encodedAlphabet.indexOf(input.charAt(i));
      decodedString += decodedAlphabet.charAt(decodedPosition);
    }
    return decodedString.trim();
  }


  private static String clean(String input) {
    String cleanedString = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    System.out.println(cleanedString);
    return cleanedString;
  }
}
