import java.util.Arrays;

public class StackBuilderByArray {
  private int[] stack = new int[5];
  private int count = 0;

  public void push(int value) {
    if (stack.length == count) {
      int[] newStack = new int[stack.length * 2];
      for (int i = 0; i < count; i++) {
        newStack[i] = stack[i];
      }
      stack = newStack;
    }
    stack[count] = value;
    count++;
  }
  
  public int pop() {
    if (isEmpty())
      throw new IllegalArgumentException();
    return stack[--count];
  }
  
  public int peek() {
    if (isEmpty())
      throw new IllegalArgumentException();
    return stack[count - 1];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public void log() {
    int[] slice = Arrays.copyOfRange(stack, 0, count);
    System.out.println(Arrays.toString(slice));
  }
}
