import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by sdargo on 23/07/16.
 */
public class Cipher {

  String key;

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
      return this.key;
    }

  public String decode(String input) {
      return this.key;
    }

  private void throwIfIllegal() {
    if (Pattern.compile(".*[A-Z0-9]*.*").matcher(this.key).matches()) {
      throw  new IllegalArgumentException();
    }
  }

  private String generateRandomKey() {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    Random random = new Random();
    StringBuilder randomString = new StringBuilder();
    while (randomString.length() < 100) {
      int index = (int) (random.nextFloat() * alphabet.length());
      randomString.append(alphabet.charAt(index));
    }
    return randomString.toString();
  }
}
