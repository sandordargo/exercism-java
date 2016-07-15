import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
/**
 * Created by sdargo on 14/07/16.
 */
public class Strain {

  interface IntegerMath {
    boolean evaluate(Integer number);
  }

  interface IntegerListMath {
    boolean evaluate(List<Integer> number);
  }


  interface StringOperation {
    boolean evaluate(String string);
  }

  public static List<List<Integer>> keep(List<List<Integer>> inputList, IntegerListMath expression) {
    List<List<Integer>> intergers = new ArrayList<>();
    for (List<Integer> number : inputList) {
      if (expression.evaluate(number)) {
        intergers.add(number);
      }
    }
    return intergers;
  }

  public static List<List<Integer>> discard(List<List<Integer>> inputList, IntegerListMath expression) {
    List<List<Integer>> intergers = new ArrayList<>();
    for (List<Integer> number : inputList) {
      if (!expression.evaluate(number)) {
        intergers.add(number);
      }
    }
    return intergers;
  }

  public static List<Integer> keep(List<Integer> inputList, IntegerMath expression) {
    List<Integer> intergers = new ArrayList<>();
    for (Integer number : inputList) {
      if (expression.evaluate(number)) {
        intergers.add(number);
      }
    }
    return intergers;
  }

  public static List<String> keep(List<String> inputList, StringOperation expression) {
    List<String> intergers = new ArrayList<>();
    for (String number : inputList) {
      if (expression.evaluate(number)) {
        intergers.add(number);
      }
    }
    return intergers;
  }

  public static List<String> discard(List<String> inputList, StringOperation expression) {
    List<String> intergers = new ArrayList<>();
    for (String number : inputList) {
      if (!expression.evaluate(number)) {
        intergers.add(number);
      }
    }
    return intergers;
  }

  public static List<Integer> discard(List<Integer> inputList, IntegerMath expression) {
    List<Integer> intergers = new ArrayList<>();
    for (Integer number : inputList) {
      if (!expression.evaluate(number)) {
        intergers.add(number);
      }
    }
    return intergers;
  }

}
