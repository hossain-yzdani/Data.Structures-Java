import java.util.Arrays;

public class StackBuilderByLinkedList {
  public class Node {
    int value;
    Node next;

    public Node(int number) {
      value = number;
    }
  }

  private Node head;
  private Node tail;
  private int count = 0;

  public void push(int number) {
    Node newNode = new Node(number);
    if (isEmpty()) {
      head = tail = newNode;
      count++;
    }
    tail.next = newNode;
    tail = newNode;
    count++;
  }

  public Node pop() {
    if (isEmpty())
      throw new IllegalArgumentException();
    Node currentNode = head;
    while (currentNode.next != tail) {
      currentNode = currentNode.next;
    }
    Node endNode = currentNode.next;
    tail = currentNode;
    tail.next = null;
    count--;
    return endNode;
  }

  public int peek() {
    return tail.value;
  }

  public boolean isEmpty() {
    return head == null && tail == null;
  }

  void log() {
    Node currentNode = head;
    int[] numbers = new int[count - 1];
    for (int i = 0; i < count - 1; i++) {
      numbers[i] = currentNode.value;
      currentNode = currentNode.next;
    }
    System.out.println(Arrays.toString(numbers));
  }
}
