
import java.util.Arrays;

// Best case performance: O(n)  - When array is already sorted, we need to iterate and compare only once, hence only n comparisons. It is built in into algorithms to check if array is sorted
// Average case performance: O(n^2)
// Worst case performance: O(n^2)
// Worst case space: O(1) auxiliary storage
// Stable sort algorithm
// Bad branch prediction and frequent cache misses
// Can efficiently detect and sort almost sorted arrays. (best case or near best case)
class BubbleSort {

  static int comparisonCount;
  static int swapCount;

  static final int[] sourceArray = {3, 2, 4, 8, 7, 1, 9, 11, 12};

  public static void main(String[] args) {

    int[] sortedArray = bubbleSort(sourceArray.clone());

    System.out.println(Arrays.toString(sortedArray));
    System.out.println("Comparison: " + comparisonCount);
    System.out.println("Swap: " + swapCount);
  }

  static int[] bubbleSort1(int[] a) {
    for (int j = a.length; j > 0; j--) {
      for (int i = 1; i < j; i++) {
        comparisonCount++;
        if (a[i - 1] > a[i]) {
          swapCount++;
          int t = a[i];
          a[i] = a[i - 1];
          a[i - 1] = t;
        }
      }
    }
    return a;
  }

  static void swap(int[] a, int i1, int i2) {
    int t = a[i1];
    a[i1] = a[i2];
    a[i2] = t;
  }

  // estimated 50% improvement in worst cases
  static int[] bubbleSort(int[] a) {
    int n = a.length;
    while(n > 0) {
      int newLastN = 0; // if no swap occurred in last step we won't need to run next iteration
      for (int i = 1; i < n; i++) {
        comparisonCount++;
        if (a[i - 1] > a[i]) {
          swapCount++;
          swap(a, i - 1, i);
          newLastN = i;
        }
      }
      n = newLastN;
    }
    return a;
  }
}
