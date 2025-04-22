package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementII229Test {

  @Test
  void majorityElement() {
    var problem = new MajorityElementII229();

    assertEquals(List.of(3), problem.majorityElement(new int[]{3, 2, 3}));
    assertEquals(List.of(1), problem.majorityElement(new int[]{1}));
    assertEquals(List.of(1, 2), problem.majorityElement(new int[]{1, 2}));
  }
}
