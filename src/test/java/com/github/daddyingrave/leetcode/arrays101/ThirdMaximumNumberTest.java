package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThirdMaximumNumberTest {

  @Test
  void thirdMax() {
    var problem = new ThirdMaximumNumber();

    assertEquals(1, problem.thirdMax(new int[]{2, 2, 3, 1}));
    assertEquals(2, problem.thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
  }
}