package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchinRotatedSortedArray33Test {
  class Solution {
    public int search(int[] nums, int target) {
      int rotationIndex = rotationPoint(nums);
      int left = 0;
      int right = nums.length - 1;
      if (target < nums[rotationIndex] || target > nums[nums.length - 1]) {
        right = rotationIndex - 1;
      }
      if (target >= nums[rotationIndex] && target <= nums[nums.length - 1]) {
        left = rotationIndex;
      }

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

    int rotationPoint(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      while (left < right) {
        int mid = left + (right - left) / 2;

        if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
          return mid + 1;
        }

        if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
          right = mid;
        } else if (nums[mid] < nums[left]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      return left;
    }
  }

  @Test
  void test() {
    assertEquals(4, new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    assertEquals(-1, new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    assertEquals(0, new Solution().search(new int[]{1}, 1));
    assertEquals(1, new Solution().search(new int[]{3, 1}, 1));
    assertEquals(0, new Solution().search(new int[]{5, 1, 3}, 5));
  }
}
