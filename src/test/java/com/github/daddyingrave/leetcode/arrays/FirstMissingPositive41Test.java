package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMissingPositive41Test {

  @Test
  void firstMissingPositive() {
    var problem = new FirstMissingPositive41();
    assertEquals(3, problem.firstMissingPositive(new int[]{1, 2, 0}));
    assertEquals(2, problem.firstMissingPositive(new int[]{3, 4, -1, 1}));
    assertEquals(1, problem.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    assertEquals(2, problem.firstMissingPositive(new int[]{1}));
    assertEquals(2, problem.firstMissingPositive(new int[]{1, 1}));
  }
}
