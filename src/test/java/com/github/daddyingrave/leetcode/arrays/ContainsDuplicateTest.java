package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

  ContainsDuplicate containsDuplicate = new ContainsDuplicate();

  @Test
  void containsDuplicate() {
    assertTrue(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}));
    assertTrue(containsDuplicate.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    assertFalse(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}));
  }
}