import java.util.Arrays;

public class ArrayBuilder {
  int[] numbers;

  public ArrayBuilder(int size) {
    numbers = new int[size];
  }

  int count = 0;

  public void add(int inputNumber) {
    if (count == numbers.length) {
      int[] newNumbers = new int[numbers.length * 2];
      for (int i = 0; i < numbers.length; i++) {
        newNumbers[i] = numbers[i];
      }
      numbers = newNumbers;
    }
    numbers[count++] = inputNumber;
  }
  
  public void remove(int index) {
    if (count == 0) {
      throw new IllegalArgumentException("The array is empty.");
    }
    for (int i = index; i < count; i++) {
      numbers[i] = numbers[i + 1];
    }
    count--;
  }

  public int indexOf(int value) {
    for (int i = 0; i < count; i++) {
      if (value == numbers[i]) {
        return i;
      }
    }
    return -1;
  }

  public boolean contains(int value) {
    for (int i = 0; i < count; i++) {
      if (value == numbers[i]) {
        return true;
      }
    }
    return false;
  }

  public void log() {
    System.out.println(Arrays.toString(numbers));
  }
}
