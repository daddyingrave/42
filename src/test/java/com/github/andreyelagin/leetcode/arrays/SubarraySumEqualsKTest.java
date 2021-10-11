package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

  SubarraySumEqualsK solution = new SubarraySumEqualsK();

  @Test
  void subarraySum() {
    assertEquals(2, solution.subarraySum(new int[]{1, 1, 1}, 2));
    assertEquals(2, solution.subarraySum(new int[]{1, 2, 3}, 3));
    assertEquals(3, solution.subarraySum(new int[]{1, -1, 0}, 0));
  }
}