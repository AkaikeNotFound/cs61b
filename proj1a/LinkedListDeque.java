public class LinkedListDeque <T> {

  /* Nested Class IntNode   */
  private class IntNode {
    public IntNode prev;
    public T item;
    public IntNode next;

    public IntNode(IntNode p, T i, IntNode n) {
      prev = p;
      item = i;
      next = n;
    }
  }

  private int size;
  private IntNode sentinel;

  public LinkedListDeque() {
    sentinel = new IntNode(null, null, null);
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
    size = 0;
  }

  /* public LinkedListDeque(T i) { */
  /* sentinel = new IntNode(null, null, null); */
  /* sentinel.next = new IntNode(sentinel, i, null); */
  /* sentinelL = sentinel.next; */
  /* size = 1; */
  /* } */

  public void addFirst(T i) {
    sentinel.next = new IntNode(sentinel, i, sentinel.next);
    sentinel.next.next.prev = sentinel.next;
     if(size==0){
      sentinel.prev = sentinel.next;
    }
    size = size + 1;
  }

  public void addLast(T i) {
    sentinel.prev = new IntNode(sentinel.prev, i, sentinel);
     sentinel.prev.prev.next = sentinel.prev;
    if(size == 0){
      sentinel.next = sentinel.prev;
    }
    size = size + 1;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    IntNode p = sentinel.next;
    for (int i = 0; i < size; i++) {
      T temp = p.item;
      System.out.print(temp + " ");
      p = p.next;
    }
  }

  public T removeFirst() {
    if (size == 0) {
      return null;
    } else {
      T temp = sentinel.next.item;
       sentinel.next.next.prev = sentinel;
       sentinel.next = sentinel.next.next;
      sentinel.next = sentinel;
      size = size - 1;
      return temp;
    }
  }

  public T removeLast() {
    if (size == 0) {
      return null;
    } else {
      T temp = sentinel.prev.item;
       sentinel.prev.prev.next = sentinel;
       size = size - 1;
      return temp;
    }
  }

  /* public T getRecursive(int index) { */

  /* IntNode p = sentinel.next; */
  /* if (index != 0) { */
  /* p = p.next; */
  /* return p.getRecursive(index-1); */
  /* } */
  /* return p.item; */
  /* } */
  public T getRecursive(int index) {
    if (index >= size)
      return null;

    else
      return getRecursive(sentinel.next, index, 0);

  }

  private  T getRecursive(IntNode p, int index, int t) {
    if (t == index) return p.item;
    else {
      return getRecursive(p.next, index, t + 1);
    }
  }

  /* public LinkedListDeque(LinkedListDeque<T> other) { */
    /* sentinel = new IntNode(null, null, null); */
    /* sentinelL = sentinel; */

    /* for (int i = 0; i < other.size; i++) { */
      /* addLast(other.get(i)); */
    /* } */
  /* } */

  public T get(int index) {
    IntNode p = sentinel.next;
    if (index > size) {
      return null;
    }
    for (int i = 0; i < index; i++) {
      p = p.next;
    }
    return p.item;
  }
}
