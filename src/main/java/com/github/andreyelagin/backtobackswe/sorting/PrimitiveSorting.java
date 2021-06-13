package com.github.andreyelagin.backtobackswe.sorting;

public class PrimitiveSorting {
  public static void bubble(int[] arr) {
    int i = 1;
    int j = arr.length - 1;
    
    while (j >= 0) {
      while (i <= j) {
        if (arr[i] < arr[i - 1]) {
          int temp = arr[i];
          arr[i] = arr[i - 1];
          arr[i - 1] = temp;
        }
        i++;
      }
      i = 1;
      j--;
    }
  }

  public static void insertion(int[] arr) {
    int i = 1;
    
    while (i < arr.length) {
      int cur = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > cur) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = cur;
      i++;
    }
  }

  public static void selection(int[] arr) {
    
  }
}
