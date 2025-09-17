package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumSizeSubarraySum209Test {


  class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int minSize = Integer.MAX_VALUE;
      int curSum = 0;
      int left = 0;
      int right = 0;

      while (right < nums.length) {
        curSum += nums[right++];
        while (curSum >= target) {
          minSize = Math.min(minSize, right - left);
          curSum -= nums[left++];
        }
      }

      return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
  }

  @Test
  void test() {
    assertEquals(2, new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    assertEquals(1, new Solution().minSubArrayLen(4, new int[]{1, 4, 4}));
    assertEquals(0, new Solution().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
  }
}
