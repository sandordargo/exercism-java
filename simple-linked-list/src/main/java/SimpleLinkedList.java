import java.util.NoSuchElementException;
/**
 * Created by sdargo on 23/07/16.
 */
public class SimpleLinkedList <T> {

  private Element last;
  private int size=0;

  public SimpleLinkedList() {

  }

  public SimpleLinkedList(T[] inputList) {
    for (T item : inputList) {
      this.push(item);
    }
  }

  public int size() {
    return size;
  }

  public void push(T data) {
    Element newElement = new Element(data);
    if (this.last != null) {
      this.last.next = newElement;
      newElement.previous = this.last;
    }
    this.last = newElement;
    this.size++;
  }

  public T pop() {
    if (this.last == null) { throw new NoSuchElementException(); }
    T returnValue = this.last.data;
    this.last = this.last.previous;
    --this.size;
    return returnValue;
  }

  public void reverse() {
    Object[] tempList = this.asArray(Object.class);
    for (Object item : tempList) {
      this.push((T) item);
    }
  }

  public Object[] asArray(Object objectType) {
    int arraySize = this.size();
    Object[] arrayToReturn = new Object[arraySize];
    while (this.size > 0) {
      arrayToReturn[arraySize - this.size()] = this.pop();
    }
    return arrayToReturn;
  }

  class Element {
    public T data;
    public Element next;
    public Element previous;

    Element(T input) {
      this.data = input;
    }
  }
}
