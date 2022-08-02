package com.github.daddyingrave.backtobackswe.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
  public int countSubarrays(int[] arr, int k) {
    Map<Integer, Integer> sums = new HashMap<>();
    sums.put(0, 1);

    int count = 0;
    int sum = 0;
    
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      
      if (sums.containsKey(sum - k)) {
        count += sums.get(sum - k);
      }
      
      if (!sums.containsKey(sum)) {
        sums.put(sum, 1);
      } else {
        sums.put(sum, sums.get(sum) + 1);
      }
    }
    
    return count;
  }

  public int countSubarraysCumulative(int[] arr, int k) {
    int[] cumulativeSum = new int[arr.length];
    cumulativeSum[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      cumulativeSum[i] = cumulativeSum[i - 1] + arr[i];
    }

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        int temp = arr[j];
        if (j != 0) {
          temp = cumulativeSum[j] - temp;
        }

        if (temp == k) {
          count++;
        }
      }
    }

    return count;
  }

  public int countSubarraysNaive(int[] arr, int k) {
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
