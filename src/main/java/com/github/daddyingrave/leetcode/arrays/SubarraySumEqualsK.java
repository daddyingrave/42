package com.github.daddyingrave.leetcode.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    int sumCount = 0;
    var sumOccurrences = new HashMap<Integer, Integer>();

    int sum = 0;
    sumOccurrences.put(0, 1);
    for (int num : nums) {
      sum += num;
      if (sumOccurrences.containsKey(sum - k)) {
        sumCount += sumOccurrences.get(sum - k);
      }
      sumOccurrences.put(sum, sumOccurrences.getOrDefault(sum, 0) + 1);
    }

    return sumCount;
  }

  public int subarraySumNaive(int[] nums, int k) {
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
