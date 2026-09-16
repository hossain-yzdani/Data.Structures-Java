public class Heap {
  private int[] items = new int[10];
  private int size;

  public void insert(int value) {
    if (isFull())
      throw new IllegalStateException();
    items[size++] = value;
    bubbleUp();
  }

  public int remove() {
    if (isEmpty())
      throw new IllegalStateException();

    var root = items[0];
    items[0] = items[--size];

    var index = 0;
    while (index <= size && !isValidParent(index)) {
      var largerChildIndex = largerChildIndex(index);
      swap(index, largerChildIndex);
      index = largerChildIndex;
    }

    return root;
  }
  
  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    if (!hasRightChild(index))
      return items[index] >= leftChild(index);

    return items[index] >= leftChild(index)
        && items[index] >= rightChild(index);
  }

  private int largerChildIndex(int index) {
    if (!hasLeftChild(index))
      return index;

    if (!hasRightChild(index))
      return leftChildIndex(index);

    return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private int leftChild(int index) {
    return items[leftChildIndex(index)];
  }

  private int rightChild(int index) {
    return items[rightChildIndex(index)];
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= size;
  }

  
  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= size;
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  private void bubbleUp() {
    var index = size - 1;
    while (index > 0 && items[index] > items[parent(index)]) {
      swap(index, parent(index));
      index = parent(index);
    }
  }
  
  private void swap(int first, int secound) {
    var temp = items[first];

    items[first] = items[secound];
    items[secound] = temp;
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private boolean isFull() {
    return size == items.length;
  }

  private boolean isEmpty() {
    return size == 0;
  }
}
