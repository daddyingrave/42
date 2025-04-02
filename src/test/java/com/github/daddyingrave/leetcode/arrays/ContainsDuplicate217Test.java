package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicate217Test {

  @Test
  void containsDuplicate() {
    var problem = new ContainsDuplicate217();

    assertTrue(problem.containsDuplicate(new int[]{1, 2, 3, 1}));
    assertTrue(problem.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    assertFalse(problem.containsDuplicate(new int[]{1, 2, 3, 4}));
  }
}
