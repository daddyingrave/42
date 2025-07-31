package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumSumCircularSubarray918Test {
  public int maxSubarraySumCircular(int[] nums) {
    int globalMax = nums[0];
    int currentMax = 0;
    int globalMin = nums[0];
    int currentMin = 0;
    long totalSum = 0;

    for (int num : nums) {
      totalSum += num;
      currentMax = Math.max(currentMax + num, num);
      globalMax = Math.max(currentMax, globalMax);
      currentMin = Math.min(currentMin + num, num);
      globalMin = Math.min(globalMin, currentMin);
    }

    if (globalMax < 0) {
      return globalMax;
    } else {
      return Math.max(globalMax, (int) (totalSum - globalMin));
    }
  }

  @Test
  void test() {
    assertEquals(10, maxSubarraySumCircular(new int[]{5, -3, 5}));
  }
}
