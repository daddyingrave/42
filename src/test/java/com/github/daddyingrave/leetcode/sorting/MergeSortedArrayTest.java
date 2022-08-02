package com.github.daddyingrave.leetcode.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

  MergeSortedArray mergeSortedArray = new MergeSortedArray();

  @Test
  void merge() {
    var expected = new int[]{1, 2, 2, 3, 5, 6};
    var toSort1 = new int[]{1, 2, 3, 0, 0, 0};
    var toSort2 = new int[]{2, 5, 6};

    mergeSortedArray.mergeEnd(toSort1, 3, toSort2, 3);
    
    assertArrayEquals(expected, toSort1);
  }
}