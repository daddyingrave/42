package com.github.daddyingrave.backtobackswe.sorting;

import java.util.Arrays;

public class PrimitiveSorting {
  public static int[] bubble(int[] arr) {
    var copy = Arrays.copyOf(arr, arr.length);
    
    for (int i = copy.length - 1; i >= 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (copy[j] < copy[j - 1]) {
          int temp = copy[j];
          copy[j] = copy[j - 1];
          copy[j - 1] = temp;
        }
      }
    }
    
    return copy;
  }

  public static int[] insertion(int[] arr) {
    var copy = Arrays.copyOf(arr, arr.length);
    
    for (int i = 1; i < copy.length; i++) {
      int cur = copy[i];
      int j;
      for (j = i - 1; j >= 0 && copy[j] > cur; j--) {
        copy[j + 1] = copy[j];
      }
      copy[j + 1] = cur;
    }
    
    return copy;
  }

  public static int[] selection(int[] arr) {
    var copy = Arrays.copyOf(arr, arr.length);

    for (int i = copy.length - 1; i > 0; i--) {
      int largest = 0;
      for (int j = 1; j <= i; j++) {
        if (copy[largest] < copy[j]) {
          largest = j;
        }
      }
      int temp = copy[i];
      copy[i] = copy[largest];
      copy[largest] = temp;
    }
    
    return copy;
  }
}
