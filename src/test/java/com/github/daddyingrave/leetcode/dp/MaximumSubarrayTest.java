package com.github.daddyingrave.leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

  MaximumSubarray maximumSubarray = new MaximumSubarray();

  @Test
  void maxSubArray() {
    assertEquals(6, maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}