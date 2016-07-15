import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by sdargo on 15/07/16.
 */
public class Accumulate {

  public static <E> List<E> accumulate(List<E> inputList, Function<E, E> function) {
    List<E> returnList = new ArrayList<>();
    for (E item : inputList) {
      returnList.add(function.apply(item));
    }
    return returnList;
  }
}
