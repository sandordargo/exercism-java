import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdargo on 12/07/16.
 */
public class PrimeFactors {

  public static List<Long> getForNumber(long input) {
    List<Long> primes = new ArrayList<>();
    long residual = input;
    while (residual > 1) {
      Pair<Long, Long> residualPrimePair = PrimeFactors.getResidualAndNextPrime(residual);
      if (residualPrimePair.getValue() != 0L) {
        primes.add(residualPrimePair.getValue());
      }
      residual = residualPrimePair.getKey();
    }
    return primes;
  }

  private static Pair<Long, Long> getResidualAndNextPrime(Long input) {
    if (input < 2) {
      return new Pair<>(input, 0L);
    }
    for (long divider = 2; divider <= input; divider++) {
      if (input % divider == 0) {
        return new Pair<>(input/divider, divider);
      }
    }
    return new Pair<>(input, 0L);
  }
}
