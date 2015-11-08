

// Worst case O(n^2) comparisons, and swaps
// Average case O(n^2) comparisons
// Best case Om(n) comparisons O(1) swaps

// Very simple implementation which works great for small arrays,
// more efficient than other quadratic algorithms. Adaptive scalability for partially sorted arrays:
// Asymptotically O(n k) when each of n element is not more far away from ints correct sorted possition than k
// Stable, in-place(?), could be used gradually
class InsertionSort {

  static final int[] sourceArray = {3, 2, 4, 8, 7, 1, 9, 11, 12};

  public static void main(String[] args) {
    int[] sortedArray = insertionSort(sourceArray.clone());

    System.out.println(java.util.Arrays.toString(sortedArray));
  }

  public static int[] insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int v = a[i];
      int j = i;
      while (j > 0 && a[j - 1] > v) {
        a[j] = a[j - 1];
        j--;

      a[j] = v;
    }
    return a;
  }
}
