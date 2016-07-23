import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by sdargo on 23/07/16.
 */
public class Cipher {

  String key;
  static String alphabet = "abcdefghijklmnopqrstuvwxyz";

  public Cipher() {
    this.key = generateRandomKey();
  }

  public Cipher(String key) {
    this.key = key;
    throwIfIllegal();
  }

  public String getKey() {
    return this.key;
  }

  public String encode(String input) {
    String encoded = new String();
    for (int i=0; i<input.length(); ++i) {
      encoded += encodeCharacter(input.charAt(i), this.key.charAt(i % this.key.length()));
    }
    return encoded;
  }

  private Character encodeCharacter(Character input, Character key) {
    int inputPosition = Cipher.alphabet.indexOf(input);
    int keyPosition = Cipher.alphabet.indexOf(key);
    return Cipher.alphabet.charAt((inputPosition + keyPosition) % Cipher.alphabet.length());
  }

  private Character decodeCharacter(Character input, Character key) {
    int inputPosition = Cipher.alphabet.indexOf(input);
    int keyPosition = Cipher.alphabet.indexOf(key);
    int decodedPosition = (inputPosition < keyPosition) ? inputPosition - keyPosition + 26 : inputPosition - keyPosition;
    return Cipher.alphabet.charAt(decodedPosition);
  }

  public String decode(String input) {
    String decoded = new String();
    for (int i=0; i<input.length(); ++i) {
      decoded += decodeCharacter(input.charAt(i), this.key.charAt(i % this.key.length()));
    }
    return decoded;
  }

  private void throwIfIllegal() {
    if (this.key.isEmpty() || Pattern.compile(".*[A-Z0-9]+.*").matcher(this.key).matches()) {
      throw  new IllegalArgumentException();
    }
  }

  private String generateRandomKey() {
    Random random = new Random();
    StringBuilder randomString = new StringBuilder();
    while (randomString.length() < 100) {
      int index = (int) (random.nextFloat() * Cipher.alphabet.length());
      randomString.append(Cipher.alphabet.charAt(index));
    }
    return randomString.toString();
  }
}
