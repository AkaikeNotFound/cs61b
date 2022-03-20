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
    begin = items.length-1;
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

  private void rateupdate(){
    rate = size*1.0/items.length;
  }

  private void copy(){
    T[] newitems = (T[]) new Object[size*4];
    if (begin > end) {
      System.arraycopy(items, begin, newitems, begin, size - begin);
      System.arraycopy(items, 0, newitems, size, begin);
      end = begin + size - 1;
    } else {
      System.arraycopy(items, begin, newitems, 0, size);
      begin = 0;
      end = size-1;
    }
    items = newitems;
  }

  private void resizing() {
    if (size > items.length) {
      this.copy();
    }
    if (rate < 0.25 && items.length > 16){
      this.copy(); 
    }
  }

  public void addFirst(T item) {
    size = size + 1;
    this.rateupdate();
    this.resizing();
    if (begin == 0) {
      begin = items.length;
    } else {
      begin = begin - 1;
    }
    items[begin] = item;
  }

  public void addLast(T item){
    size = size + 1;
    this.rateupdate();
    this.resizing();
    if (end == items.length){
      end = 0;
    }else{
      end = end + 1;
    }
    items[end] = item;
  }

  public boolean isEmpty(){
    if (size == 0){
      return true;
    }else{
      return false;
    }
  }

  public int size(){
    return size;
  }

  public void printDeque(){
    int curr = begin;
    for(int i=0;i<size;i++){
      System.out.print(items[curr] + " ");
      curr = curr + 1;
      if (curr == items.length){
        curr = 0;
      }
    }
  }

  public T removeFirst(){
    size = size - 1;
    this.rateupdate();
    this.resizing();
    T temp = items[begin]; 
    if (begin == items.length){
      begin = 0;
    }else{
      begin = begin + 1;
    }
    return temp;
  }

  public T removeLast(){
    size = size - 1;
    this.rateupdate();
    this.resizing();
    T temp = items[end];
    if(end == 0){
      end = items.length;
    }else{
      end = end - 1;
    }
    return temp;
  }

  public T get(int index){
    if (begin+index > items.length){
      return items[begin+index - items.length-1];
    }else{
      return items[begin+index];
    }
  }


}
