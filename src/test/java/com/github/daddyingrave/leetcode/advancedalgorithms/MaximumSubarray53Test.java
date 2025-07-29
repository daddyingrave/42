package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumSubarray53Test {
  public int maxSubArray(int[] nums) {
    int maxSum = 0;
    int curSum = 0;

    for (int num : nums) {
      curSum = Math.max(curSum, 0);
      curSum += num;
      maxSum = Math.max(curSum, maxSum);
    }

    return maxSum;
  }

  @Test
  void test() {
    assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}
