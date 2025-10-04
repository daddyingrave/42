package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindMinimuminRotatedSortedArray153Test {
  class Solution {
    public int findMin(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      while (left < right) {
        int mid = left + (right - left) / 2;

        if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
          return nums[mid + 1];
        }

        if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
          right = mid;
        } else if (nums[mid] < nums[left]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      return nums[left];
    }
  }

  @Test
  void test() {

  }
}
