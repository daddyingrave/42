package com.github.daddyingrave.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArrayTest {

  @Test
  void findMin() {
    var problem = new FindMinimumInRotatedSortedArray();

    assertEquals(1, problem.findMin(new int[]{3, 4, 5, 1, 2}));
    assertEquals(11, problem.findMin(new int[]{11, 13, 15, 17}));
    assertEquals(1, problem.findMin(new int[]{1, 2}));
    assertEquals(1, problem.findMin(new int[]{5, 1, 2, 3, 4}));
  }
}