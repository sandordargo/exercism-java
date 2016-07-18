import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdargo on 18/07/16.
 */
public class RnaTranscription {

  private static Map<Character, Character> dnaRnaMap;

  static {
    RnaTranscription.dnaRnaMap = new HashMap<>();
    RnaTranscription.dnaRnaMap.put('G', 'C');
    RnaTranscription.dnaRnaMap.put('C', 'G');
    RnaTranscription.dnaRnaMap.put('T', 'A');
    RnaTranscription.dnaRnaMap.put('A', 'U');
  }

  public static String ofDna(String dna) {
    String transcription = "";
    for (Character character : dna.toCharArray()) {
      if (RnaTranscription.dnaRnaMap.containsKey(character)) {
        transcription += RnaTranscription.dnaRnaMap.get(character);
      }
    }
    return transcription;
  }
}
