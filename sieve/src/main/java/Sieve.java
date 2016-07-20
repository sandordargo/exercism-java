import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sdargo on 20/07/16.
 */
public class Sieve {

  Map<Integer, Boolean> sieveMap;
  Integer rangeUpperLimit;

  public Sieve(Integer rangeUpperLimit) {
    this.rangeUpperLimit = rangeUpperLimit;
    initializeSieveMap(rangeUpperLimit);
  }

  private void initializeSieveMap(Integer rangeUpperLimit) {
    this.sieveMap = new HashMap<>();
    for (int i=2; i<=rangeUpperLimit; ++i) {
      this.sieveMap.put(i, false);
    }
  }

  List<Integer> getPrimes() {
    List<Integer> primes = new ArrayList<>();
    this.sieveMap.entrySet().stream().filter(entry -> entry.getValue() == false).forEachOrdered(entry -> {
      primes.add(entry.getKey());
      markMultiples(entry.getKey());
    });
    return primes;
  }

  private void markMultiples(Integer base) {
    for (int i=base; i<=this.rangeUpperLimit; i+=base) {
      this.sieveMap.replace(i, true);
    }
  }
}
