import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by sdargo on 14/07/16.
 */
public class Strain {

  public static <T> List<T> keep(List<T> inputList, Function<T, Boolean> expression) {
    List<T> returnList = new ArrayList<>();
    for (T item : inputList) {
      if (expression.apply(item)) {
        returnList.add(item);
      }
    }
    return returnList;
  }

  public static <T> List<T> discard(List<T> inputList, Function<T, Boolean> expression) {
    return keep(inputList, item -> !expression.apply(item));
  }
}
