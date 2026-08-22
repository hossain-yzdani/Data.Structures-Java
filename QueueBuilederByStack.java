import java.util.Stack;

public class QueueBuilederByStack {

  private Stack<Integer> stackOne = new Stack<>();
  private Stack<Integer> stackTwo = new Stack<>();

  public void enqueu(int item) {
    stackOne.push(item);
  }

  public int dequeue() {
    if (isEmpty())
      throw new IllegalArgumentException();
    if (stackTwo.isEmpty()) {
      while (!stackOne.isEmpty())
        stackTwo.push(stackOne.pop());
    }
    return stackTwo.pop();
  }

  public int peek() {
    if (isEmpty())
      throw new IllegalArgumentException();
    if (stackTwo.isEmpty()) {
      while (!stackOne.isEmpty())
        stackTwo.push(stackOne.pop());
    }
    return stackTwo.peek();
  }

  public boolean isEmpty() {
    return stackOne.isEmpty() && stackTwo.isEmpty();
  }

}
