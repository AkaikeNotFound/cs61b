public class ArrayDeque<T> {
  private T[] items;
  private int size;
  private double rate;
  private int begin;
  private int end;



  public ArrayDeque() {
    items = (T[]) new Object[8];
    size = 0;
    rate = 0;
    begin = 1;
    end = 0;
  }

  /* public ArrayDeque(T item) { */
  /* items = (T []) new Object[8]; */
  /* items[0] = item; */
  /* size = 1; */
  /* begin = 0; */
  /* end = 1; */
  /* this.rateupdate(); */
  /* } */

  private void rateupdate() {
    rate = size * 1.0 / items.length;
  }

  private void copy(int m) {
    T[] newitems = (T[]) new Object[size * m];
    if (begin > end) {
      System.arraycopy(items, begin, newitems, newitems.length + begin - items.length, items.length - begin);
      System.arraycopy(items, 0, newitems, 0, end + 1);
    } else {
      System.arraycopy(items, begin, newitems, 0, size);
    }
    begin = newitems.length + begin - items.length;
    items = newitems;
  }

  private void resizing() {
    this.rateupdate();
    if (size > items.length) {
      this.copy(4);
    }
    if (rate < 0.25 && items.length > 16) {
      this.copy(2);
    }
    this.rateupdate();
  }

  public void addFirst(T item) {

    size = size + 1;
    this.resizing();
    if (begin == 0) {
      begin = items.length - 1;
    } else {
      begin = begin - 1;
    }
    items[begin] = item;
  }

  public void addLast(T item) {

    size = size + 1;
    this.resizing();
    if (end == items.length - 1) {
      end = 0;
    } else {
      end = end + 1;
    }
    items[end] = item;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    int curr = begin;
    for (int i = 0; i < size; i++) {
      System.out.print(items[curr] + " ");

      if (curr == items.length - 1) {
        curr = 0;
      } else {
        curr = curr + 1;
      }
    }
  }

  public T removeFirst() {
    if (size == 0) {
      return null;
    }
    size = size - 1;
    this.resizing();
    T temp = items[begin];
    if (begin == items.length - 1) {
      begin = 0;
    } else {
      begin = begin + 1;
    }
    return temp;
  }

  public T removeLast() {
    if (size == 0) {
      return null;
    }
    size = size - 1;
    this.resizing();
    T temp = items[end];
    if (end == 0) {
      end = items.length - 1;
    } else {
      end = end - 1;
    }
    return temp;
  }

     public T get(int index) {
        if (begin + index >= items.length) {
            return items[begin + index - items.length];
        } else {
            return items[begin + index];
        }
    }

}
