public class QuickSort {
  public void sort(int[] array){
    sort(array, 0, array.length - 1);
  }

  private void sort(int[] array, int start, int end) {
    if(start >= end)
      return;

    var boundary = partision(array, start, end);

    sort(array, start, boundary - 1);
    sort(array, boundary + 1, end);
  }

  private int partision(int[] array, int start, int end) {
    var poviot = array[end];
    var boundary = start - 1;

    for (var i = start; i <= end; i++) {
      if (array[i] <= poviot) {
        swap(array, i, ++boundary);
      }
    }
    return boundary;
  }
  
  private void swap(int[] array, int indexOne, int indexTwo) {
    int saving = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = saving;
  }
}
