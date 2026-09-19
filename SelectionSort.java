public class SelectionSort {
  public void sort(int[] array) {
    for (var i = 0; i < array.length; i++) {
      var minIndex = i;
      for (var j = i; j < array.length; j++)
        if (array[j] < array[minIndex])
          minIndex = j;
      swap(array, minIndex, i);
    }
  }
  
  private void swap(int[] array, int indexOne, int indexTwo) {
    int saving = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = saving;
  }
}
