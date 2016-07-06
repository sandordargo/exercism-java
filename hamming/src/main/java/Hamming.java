public class Hamming {

  public static int compute(String leftHandString, String rightHandString) {
    if (leftHandString.length() != rightHandString.length()) {
      throw new IllegalArgumentException();
    }

    int hamming_score = 0;
    for (int i=0; i<leftHandString.length(); i++) {
      if (leftHandString.charAt(i) != rightHandString.charAt(i)) {
        hamming_score++;
      }
    }
    return hamming_score;
  }
}
