import java.util.Arrays;

public class LinkedListBuilder {
  private class Node {
    int value;
    Node next;

    public Node(int number) {
      value = number;
    }
  }

  private Node head;
  private Node tail;
  private int count = 0;

  public void addFirst(int value) {
    Node newNode = new Node(value);
    if (count == 0) {
      head = tail = newNode;
      count++;
      return;
    }
    newNode.next = head;
    head = newNode;
    count++;
  }

  public void addEnd(int value) {
    Node newNode = new Node(value);
    if (count == 0) {
      head = tail = newNode;
      count++;
      return;
    }
    tail.next = newNode;
    tail = tail.next;
    count++;
  }

  public void deleteFirst() {
    if (count == 0) {
      throw new IllegalArgumentException();
    }
    Node newHead = head.next;
    head = newHead;
    count--;
  }

  public void deleteEnd() {
    if (count == 0) {
      throw new IllegalArgumentException();
    }
    Node currentNode = head;
    for (int i = 0; i < count; i++) {
      if (currentNode.next == tail) {
        currentNode.next = null;
        tail = currentNode;
        count--;
        return;
      } else {
        currentNode = currentNode.next;
      }
    }
  }

  public int size() {
    return this.count;
  }

  public void log() {
    int[] numbers = new int[count];
    Node currentNode = head;
    for (int i = 0; i < count; i++) {
      numbers[i] = currentNode.value;
      currentNode = currentNode.next;
    }
    System.out.println(Arrays.toString(numbers));
  }
}
