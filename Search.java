public class Search {
  public int linearSearch(int[] array, int number) {
    for (var i = 0; i < array.length; i++)
      if (number == array[i])
        return i;
    return -1;
  }

  public int binarySearch(int[] array, int number) {
    return binarySearch(array, number, 0, array.length - 1);
  }
  
  private int binarySearch(int[] array, int number, int left, int right) {
    if (right < left)
      return -1;

    int middle = (left + right) / 2;
    if (array[middle] == number)
      return middle;

    if (array[number] > number)
      return binarySearch(array, number, left, middle - 1);

    return binarySearch(array, number, middle + 1, right);
  }

  public int ternarySearch(int[] array, int number){
    return ternarySearch(array, number, 0, array.length - 1);
  }
  
  private int ternarySearch(int[] array, int number, int left, int right) {
    if (right < left)
      return -1;
    
    int partitionSize = (right - left) / 3;
    int middleOne = left + partitionSize;
    int middleTwo = right - partitionSize;

    if (array[middleOne] == number)
      return middleOne;

    if (array[middleTwo] == number)
      return middleTwo;

    if (array[middleOne] > number)
      return ternarySearch(array, number, left, middleOne - 1);

    if (array[middleOne] < number && array[middleTwo] > number)
      return ternarySearch(array, number, middleOne + 1, middleTwo - 1);

    return ternarySearch(array, number, middleTwo + 1, right);
  }
  
}
