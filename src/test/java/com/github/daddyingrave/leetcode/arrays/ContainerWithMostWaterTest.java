package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

  ContainerWithMostWater solution = new ContainerWithMostWater();

  @Test
  void maxArea() {
    assertEquals(1, solution.maxArea(new int[]{1, 1}));
    assertEquals(16, solution.maxArea(new int[]{4, 3, 2, 1, 4}));
    assertEquals(2, solution.maxArea(new int[]{1, 2, 1}));
    assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    assertEquals(17, solution.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    assertEquals(1, solution.maxArea(new int[]{1, 2}));
    assertEquals(24, solution.maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
  }
}