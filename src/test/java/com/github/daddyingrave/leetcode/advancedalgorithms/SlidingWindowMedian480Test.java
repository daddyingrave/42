package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowMedian480Test {
  class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
      return null;
    }
  }

  @Test
  void test() {
    assertArrayEquals(
        new double[]{1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000},
        new Solution().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
    );
  }
}
