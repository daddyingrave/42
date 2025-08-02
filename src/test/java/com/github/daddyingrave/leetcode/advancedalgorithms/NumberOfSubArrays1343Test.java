package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfSubArrays1343Test {
  // 2, 2, 2, 2, 5, 5, 5, 8
  // 3
  // 4
  //
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int result = 0;
    int left = 0;
    int right = 0;
    int sum = 0;
    threshold *= k;

    while (right < arr.length) {
      if (right - left == k) {
        sum -= arr[left];
        left++;
      }

      sum += arr[right];
      if (right - left == k - 1 && sum >= threshold) {
        result++;
      }

      right++;
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(3, numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    assertEquals(6, numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
  }
}


