package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortedArray88Test {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] copy1 = new int[m];
    System.arraycopy(nums1, 0, copy1, 0, m);

    int ptr = 0;
    int left = 0;
    int right = 0;
    while (left < m && right < n) {
      if (copy1[left] <= nums2[right]) {
        nums1[ptr] = copy1[left++];
      } else {
        nums1[ptr] = nums2[right++];
      }
      ptr++;
    }

    while (left < m) {
      nums1[ptr++] = copy1[left++];
    }
    while (right < n) {
      nums1[ptr++] = nums2[right++];
    }
  }

  @Test
  void test() {
    int[] actual1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] actual2 = new int[]{2, 5, 6};
    int[] expected = new int[]{1, 2, 2, 3, 5, 6};
    merge(actual1, 3, actual2, 3);
    assertArrayEquals(expected, actual1);
  }
}
