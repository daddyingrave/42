package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

public class SplitArrayLargestSum410Test {
  class Solution {
    public int splitArray(int[] nums, int k) {
      int left = Integer.MIN_VALUE;
      int right = 0;

      for (int num : nums) {
        left = Math.max(left, num);
        right += num;
      }

      int result = right;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (canSplit(nums, k, mid)) {
          result = mid;
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return result;
    }

    boolean canSplit(int[] nums, int k, int limit) {
      int subArraysCount = 0;
      int curSum = 0;

      for (int num : nums) {
        curSum += num;
        if (curSum > limit) {
          subArraysCount++;
          curSum = num;
        }
      }

      return subArraysCount + 1 <= k;
    }
  }

  @Test
  void test() {

  }
}
