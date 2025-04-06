package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElement169Test {

  @Test
  void majorityElement() {
    var problem = new MajorityElement169();
    assertEquals(3, problem.majorityElement(new int[]{3, 2, 3}));
    assertEquals(2, problem.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    assertEquals(9, problem.majorityElement(new int[]{10, 9, 9, 9, 10}));
  }
}
