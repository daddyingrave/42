package com.github.andreyelagin.backtobackswe.searching;

import java.util.Arrays;

public class KthLargestElement {
  // haha
  public int kthLargest(int[] arr, int k) {
    Arrays.sort(arr);
    return arr[arr.length - k];
  }
}
