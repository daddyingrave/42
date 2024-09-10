package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P88MergeSortedArrayTest {

  @Test
  void merge() {
    var nums1 = new int[]{1, 2, 3, 0, 0, 0};
    var nums2 = new int[]{2, 5, 6};

    var testArr = new P88MergeSortedArray();
    testArr.merge(nums1, 3, nums2, 3);

    assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
  }

  @Test
  void merge2() {
    var nums1 = new int[]{1};
    var nums2 = new int[]{};

    var testArr = new P88MergeSortedArray();
    testArr.merge(nums1, 1, nums2, 0);

    assertArrayEquals(new int[]{1}, nums1);
  }

  @Test
  void merge3() {
    var nums1 = new int[]{2, 0};
    var nums2 = new int[]{1};

    var testArr = new P88MergeSortedArray();
    testArr.merge(nums1, 1, nums2, 1);

    assertArrayEquals(new int[]{1, 2}, nums1);
  }
}