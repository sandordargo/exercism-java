/**
 * Created by sdargo on 21/07/16.
 */
public class Deque<T> {
  private Element firstElement;
  private Element lastElement;

  public void push(T newElement) {
    if (this.lastElement == null) {
      this.lastElement = new Element(newElement);
      this.firstElement = this.lastElement;
    } else {
      this.lastElement.nextElement = new Element(newElement);
      this.lastElement.nextElement.previousElement = lastElement;
      this.lastElement = this.lastElement.nextElement;
    }
  }

  public void unshift(T newElement) {
    if (this.firstElement == null) {
      this.firstElement = new Element(newElement);
      this.lastElement = this.firstElement;
    } else {
      this.firstElement.previousElement= new Element(newElement);
      this.firstElement.previousElement.nextElement = this.firstElement;
      this.firstElement = this.firstElement.previousElement;
    }
  }

  public T shift() {
    T returnElement = this.firstElement.data;
    this.firstElement = this.firstElement.nextElement;
    return returnElement;
  }

  public T pop() {
    T returnElement = this.lastElement.data;
    this.lastElement = this.lastElement.previousElement;
    return returnElement;
  }

  private class Element {
    public T data;
    public Element nextElement;
    public Element previousElement;

    Element(T data) {
      this.data = data;
    }

  }
}