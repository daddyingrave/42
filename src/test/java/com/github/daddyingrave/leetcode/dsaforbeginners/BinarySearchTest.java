package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (target < nums[mid]) {
        right = mid - 1;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  @Test
  void test() {
    assertEquals(2, search(new int[]{1, 2, 3, 4, 5}, 3));
    assertEquals(2, search(new int[]{1, 2, 3, 4, 5, 6}, 3));
    assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    assertEquals(-1, search(new int[]{1, 2, 3, 4, 5}, 8));
  }
}
