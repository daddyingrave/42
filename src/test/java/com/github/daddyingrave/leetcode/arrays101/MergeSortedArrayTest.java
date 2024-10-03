package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

  @Test
  void merge() {
    var problem = new MergeSortedArray();

    int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] arr2 = new int[]{2, 5, 6};
    int[] expected = new int[]{1, 2, 2, 3, 5, 6};

    problem.merge(arr1, 3, arr2, 3);
    assertArrayEquals(expected, arr1);
  }
}