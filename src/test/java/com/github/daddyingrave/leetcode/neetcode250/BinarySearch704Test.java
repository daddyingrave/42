package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearch704Test {
  class Solution {
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
          return mid;
        } else if (target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return -1;
    }
  }

  @Test
  void test() {
    assertEquals(-1, new Solution().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    assertEquals(0, new Solution().search(new int[]{5}, 5));
  }
}
