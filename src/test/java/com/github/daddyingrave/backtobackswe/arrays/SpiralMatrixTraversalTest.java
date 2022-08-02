package com.github.daddyingrave.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTraversalTest {

  SpiralMatrixTraversal traversal = new SpiralMatrixTraversal();

  @Test
  void spiralOrder() {
    int[][] m = new int[][]{
        new int[]{1, 2, 3},
        new int[]{4, 5, 6},
        new int[]{7, 8, 9}
    };

    assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), traversal.spiralOrder(m));
  }
}