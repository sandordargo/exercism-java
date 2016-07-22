/**
 * Created by sdargo on 22/07/16.
 */
public class Prime {

  public static int nth(int number) {
    if (number < 1) { throw new IllegalArgumentException(); }
    int counter = 1;
    int nthPrime = 2;
    while (counter < number) {
      nthPrime = getNextPrime(nthPrime);
      ++counter;
    }
    return nthPrime;
  }

  public static int getNextPrime(int from) {
    int candidate = from+1;
    while (!isPrime(candidate)) {
      ++candidate;
    }
    return candidate;
  }

  private static boolean isPrime(int candidateNumber) {
    for (int i=2; i < candidateNumber; ++i) {
      if (candidateNumber % i == 0) { return false; }
    }
    return true;
  }
}
