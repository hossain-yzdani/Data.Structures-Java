public class BubbleSort {
  public void sort(int[] array) {
    boolean swapped;
    for (var item = 0; item < array.length - 1; item++) {
      swapped = false;
      for (var index = 0; index < array.length - 1 - item; index++) {
        if (array[index] > array[index + 1]) {
          swap(array, index, index + 1);
          swapped = true;
        }
      }
      if (!swapped) break;
    }
  }

  private void swap(int[] array, int indexOne, int indexTwo) {
    int saving = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = saving;
  }
}