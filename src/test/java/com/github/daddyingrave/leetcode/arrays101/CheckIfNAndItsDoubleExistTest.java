package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfNAndItsDoubleExistTest {

  @Test
  void checkIfExist() {
    var problem = new CheckIfNAndItsDoubleExist();

    assertTrue(problem.checkIfExist(new int[]{10, 2, 5, 3}));
    assertFalse(problem.checkIfExist(new int[]{3, 1, 7, 11}));
    assertTrue(problem.checkIfExist(new int[]{7, 1, 14, 11}));
  }
}