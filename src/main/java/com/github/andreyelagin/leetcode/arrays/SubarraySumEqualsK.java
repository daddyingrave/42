package com.github.andreyelagin.leetcode.arrays;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int[] prefixSums = new int[nums.length + 1];
    for (int i = 1; i < nums.length + 1; i++) {
      prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
    }
    
    int sumCount = 0;
    for (int i = 0; i < prefixSums.length; i++) {
      for (int j = i + 1; j < prefixSums.length; j++) {
        if (prefixSums[j] - prefixSums[i] == k) {
          sumCount++;
        }
      }
    }
    
    return sumCount;
  }
}
