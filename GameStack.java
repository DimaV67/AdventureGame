import java.util.Arrays;
public class GameStack<E> {
  private int size = 0;
  private static final int DEFAULT_CAPACITY = 10;
  private Object elements[];

  public GameStack() {
    elements = new Object[DEFAULT_CAPACITY];
  }

  public void push(E e) {
    if (size == elements.length) {
      ensureCapa();
    }
    elements[size++] = e;
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    E e = (E) elements[--size];
    elements[size] = null;
    return e;
  }

  private void ensureCapa() {
    int newSize = elements.length * 2;
    elements = Arrays.copyOf(elements, newSize);
  }
} 