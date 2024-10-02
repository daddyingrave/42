package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquaresOfSortedArrayTest {

  @Test
  void sortedSquares() {
    var problem = new SquaresOfSortedArray();

    assertArrayEquals(new int[]{0, 1, 9, 16, 100}, problem.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
  }

  @Test
  void sortedSquares2() {
    var problem = new SquaresOfSortedArray();

    assertArrayEquals(new int[]{1, 4, 4}, problem.sortedSquares(new int[]{-1, 2, 2}));
  }
}