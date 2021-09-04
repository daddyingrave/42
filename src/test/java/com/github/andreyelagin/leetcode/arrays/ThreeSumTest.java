package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

  ThreeSum problem = new ThreeSum();

  @Test
  void threeSum() {
    assertEquals(
        List.of(
            List.of(-1, -1, 2),
            List.of(-1, 0, 1)),
        problem.threeSum(new int[]{-1, 0, 1, 2, -1, -4})
    );
    assertEquals(
        List.of(),
        problem.threeSum(new int[]{})
    );
    assertEquals(
        List.of(),
        problem.threeSum(new int[]{0})
    );
  }
}