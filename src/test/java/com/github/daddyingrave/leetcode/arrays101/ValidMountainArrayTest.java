package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidMountainArrayTest {

  @Test
  void validMountainArray() {
    var problem = new ValidMountainArray();

    assertFalse(problem.validMountainArray(new int[]{2, 1, 2, 3, 5, 7, 9, 10, 12, 14, 15, 16, 18, 14, 13}));
    assertFalse(problem.validMountainArray(new int[]{1, 1, 1, 1, 1, 1, 1, 2, 1}));
    assertFalse(problem.validMountainArray(new int[]{3, 5, 5}));
    assertFalse(problem.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    assertFalse(problem.validMountainArray(new int[]{4, 4, 3, 2, 1}));
    assertTrue(problem.validMountainArray(new int[]{0, 1, 2, 4, 2, 1}));
    assertTrue(problem.validMountainArray(new int[]{0, 3, 2, 1}));
    assertTrue(problem.validMountainArray(new int[]{1, 3, 2}));
  }
}