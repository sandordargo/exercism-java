import java.util.*;

/**
 * Created by sdargo on 17/07/16.
 */
public class Crypto {
  private String input;
  private String normalized;
  private int squaresize;
  private List<String> plaintextSegments;
  private int rows;

  public Crypto(String input) {
    this.input = input;
    this.normalized = normalize(input);
    this.squaresize = calculateSquareSize();
    this.plaintextSegments = buildPlaintextSegments();
    this.rows = this.plaintextSegments.size();
  }

  public String getNormalizedPlaintext() {
    return this.normalized;
  }

  public int getSquareSize() {
    return this.squaresize;
  }

  public List<String> getPlaintextSegments() {
    return this.plaintextSegments;
  }

  public String getCipherText() {
    String cypheredText = "";
    List<String> strings = this.getPlaintextSegments();
    for (int i=0; i<this.squaresize; i++) {
      for (int j=0; j<this.rows; j++) {
        if (i < strings.get(j).length()) {
          cypheredText += strings.get(j).charAt(i);
        }
      }
    }
    return cypheredText;
  }

  public String getNormalizedCipherText() {
    String normalizedChipher = "";
    String cipheredText = this.getCipherText();
    int fillingSpaces = this.rows * this.squaresize - cipheredText.length();
    Map<Integer, String> rowTextMap = new HashMap<>();
    int position = 0;
    for (int rowNumber=0; rowNumber < this.squaresize; rowNumber++) {
      int length = this.rows;
      if (rowNumber + 1 > this.squaresize - fillingSpaces) {
        length = this.rows - 1;
      }
      rowTextMap.put(rowNumber + 1, cipheredText.substring(position, position + length));
      position += length;
    }
    for (Map.Entry<Integer, String> entry : rowTextMap.entrySet()) {
      normalizedChipher += entry.getValue() + " ";
    }
    return normalizedChipher.trim();
  }

  private List<String> buildPlaintextSegments() {
    List<String> strings = new ArrayList<String>();
    int index = 0;
    while (index < this.normalized.length()) {
      strings.add(this.normalized.substring(index, Math.min(index + this.squaresize, this.normalized.length())));
      index += this.squaresize;
    }
    return strings;
  }

  private String normalize(String input) {
    return input.toLowerCase().replaceAll("[^a-z0-9]", "");
  }

  private int calculateSquareSize() {
    int  squaresize = (int) Math.sqrt((double) this.normalized.length());
    if (squaresize * squaresize < this.normalized.length())
    {
      squaresize++;
    }
    return squaresize;
  }
}
