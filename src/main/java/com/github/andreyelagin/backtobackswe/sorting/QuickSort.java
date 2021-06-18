package com.github.andreyelagin.backtobackswe.sorting;

import java.util.Arrays;

public class QuickSort {
  public int[] quicksort(int[] arr) {
    var copy = Arrays.copyOf(arr, arr.length);
    
    split(copy, 0, arr.length - 1);
    
    return copy;
  }

  private void split(int[] arr, int left, int right) {
    if (left < right) {
      int pivot = partition(arr, left, right);
      
      split(arr, left, pivot - 1);
      split(arr, pivot + 1, right);
    }
  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[right];

    int i = left - 1;
    int j = left;
    
    while (j < right) {
      if (arr[j] <= pivot) {
        swap(arr, ++i, j++);
      } else {
        j++;
      }
    }
    
    swap(arr, i + 1, right);
    
    return i + 1;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
