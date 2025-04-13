package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumMatrixTest {

  @Test
  void sumRegion() {
    var problem = new NumMatrix(new int[][]{
        new int[]{3, 0, 1, 4, 2},
        new int[]{5, 6, 3, 2, 1},
        new int[]{1, 2, 0, 1, 5},
        new int[]{4, 1, 0, 1, 7},
        new int[]{1, 0, 3, 0, 5},
    });

    assertEquals(8, problem.sumRegion(2, 1, 4, 3));
  }

  @Test
  void sumRegion2() {
    var problem = new NumMatrix(new int[][]{
        new int[]{1},
        new int[]{-7},
    });

    assertEquals(1, problem.sumRegion(0,0,0,0));
  }
}
