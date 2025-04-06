package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSum1Test {

  @Test
  void twoSum() {
    var problem = new TwoSum1();

    assertArrayEquals(new int[]{1, 0}, problem.twoSum(new int[]{2, 7, 11, 15}, 9));
    assertArrayEquals(new int[]{2, 1}, problem.twoSum(new int[]{3,2,4}, 6));
  }
}
