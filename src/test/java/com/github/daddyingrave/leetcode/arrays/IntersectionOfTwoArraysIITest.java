package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoArraysIITest {

  IntersectionOfTwoArraysII intersection = new IntersectionOfTwoArraysII();

  @Test
  void intersect() {
    assertArrayEquals(
        new int[]{2, 2},
        intersection.intersect(
            new int[]{1, 2, 2, 1},
            new int[]{2, 2}
        ));
    assertArrayEquals(
        new int[]{4, 9},
        intersection.intersect(
            new int[]{4, 9, 5},
            new int[]{9, 4, 9, 8, 4}
        ));
  }
}