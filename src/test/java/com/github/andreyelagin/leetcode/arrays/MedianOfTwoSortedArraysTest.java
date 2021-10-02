package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

  MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
  
  @Test
  void findMedianSortedArrays() {
    assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    assertEquals(0, solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
    assertEquals(1, solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
    assertEquals(2, solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
  }
}