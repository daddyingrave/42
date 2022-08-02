package com.github.daddyingrave.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumInRotatedSortedArrayTest {

  MinimumInRotatedSortedArray min = new MinimumInRotatedSortedArray();

  @Test
  void findMin() {
    assertEquals(1, min.findMin(new int[]{4, 5, 6, 7, 1, 2}));
    assertEquals(-1, min.findMin(new int[]{}));
    assertEquals(2, min.findMin(new int[]{55, 88, 91, 93, 2, 9, 20}));
  }
}