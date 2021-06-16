package com.github.andreyelagin.backtobackswe.sorting;

public class CountingInversions {
  public int countInversions(int[] A) {
    return mergeSort(A, 0, A.length - 1);
  }

  private int mergeSort(int[] arr, int left, int right) {
    int inversions = 0;
    
    if (right > left) {
      int mid = left + ((right - left) / 2);
      
      inversions += mergeSort(arr, left, mid);
      inversions += mergeSort(arr, mid + 1, right);

      inversions += merge(arr, left, mid, right);
    }

    return inversions;
  }

  private int merge(int[] arr, int left, int mid, int right) {
    int[] newArr = new int[right - left + 1];
    
    int i = left;
    int j = mid + 1;
    int newArrIndex = 0;
    int inversions = 0;
    
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        newArr[newArrIndex++] = arr[i++];
      } else {
        newArr[newArrIndex++] = arr[j++];
        inversions += (mid + 1 - i);
      }
    }
    
    while (i <= mid) {
      newArr[newArrIndex++] = arr[i++];
    }
    while (j <= right) {
      newArr[newArrIndex++] = arr[j++];
    }

    for (int k = left; k <= right; k++) {
      arr[k] = newArr[k - left];
    }
    
    return inversions;
  }
}
