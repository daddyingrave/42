package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySumEqualsK560Test {

  @Test
  void subarraySum() {
    var problem = new SubarraySumEqualsK560();
    assertEquals(2, problem.subarraySum(new int[]{1, 1, 1}, 2));
    assertEquals(2, problem.subarraySum(new int[]{1, 2, 3}, 3));
    assertEquals(3, problem.subarraySum(new int[]{0, 0}, 0));
    assertEquals(1, problem.subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100));
  }
}
