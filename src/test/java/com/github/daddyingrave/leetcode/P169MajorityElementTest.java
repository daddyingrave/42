package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P169MajorityElementTest {

  @Test
  void majorityElement() {
    var problem = new P169MajorityElement();

    assertEquals(3, problem.majorityElement(new int[]{3, 2, 3}));
    assertEquals(2, problem.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
  }
}