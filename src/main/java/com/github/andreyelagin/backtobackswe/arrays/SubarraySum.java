package com.github.andreyelagin.backtobackswe.arrays;

public class SubarraySum {
  public int countSubarrays(int[] arr, int k) {
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      int sum = arr[i];
      if (sum == k) {
        count++;
      }
      for (int j = i + 1; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          count++;

        }
      }
    }

    return count;
  }
}
