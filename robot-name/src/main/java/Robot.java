import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sdargo on 04/07/16.
 */
public class Robot {
  private String name;
  private static List<String> names = new ArrayList<>();

  Robot() {
    this.name = generateName();
  }

  public String getName() {
    return this.name;
  }

  public void reset() {
    names.remove(this.name);
    this.name = generateName();
  }

  private String generateName() {
    String robot_name = getRandomString();
    if (names.contains(robot_name)) {
      robot_name = generateName();
    }
    else {
      names.add(robot_name);
    }
    return robot_name;
  }

  private static String getRandomString() {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numbers = "0123456789";
    Random random = new Random();
    StringBuilder randomString = new StringBuilder();
    while (randomString.length() < 2) {
      int index = (int) (random.nextFloat() * alphabet.length());
      randomString.append(alphabet.charAt(index));
    }
    while (randomString.length() < 5) {
      int index = (int) (random.nextFloat() * numbers.length());
      randomString.append(numbers.charAt(index));
    }
    return randomString.toString();
  }
}
