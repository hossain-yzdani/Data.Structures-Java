public class QueueBuilederByArray {
  int[] numbers;

  public QueueBuilederByArray(int number){
    numbers = new int[number];
  }

  private int fornt;
  private int back;
  private int count = 0;

  
  public void enqueue(int number) {
    if (isFull()) {
      throw new IllegalArgumentException();
    }
    numbers[fornt] = number;
    fornt = (fornt + 1) % numbers.length;
    count++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException();
    }
    int item = numbers[back];
    numbers[back] = 0;
    back = (back + 1) % numbers.length;
    count--;
    return item;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException();
    }
    return numbers[count - 1];
  }

  public boolean isEmpty() {
    return count == 0 ? true : false;
  }

  public boolean isFull() {
    return count == numbers.length ? true : false;
  }

}
