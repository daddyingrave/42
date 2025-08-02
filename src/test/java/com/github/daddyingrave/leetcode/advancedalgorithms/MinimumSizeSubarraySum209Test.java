package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumSizeSubarraySum209Test {
  // 2, 3, 1, 2, 4, 3
  // 7
  public int minSubArrayLen(int target, int[] nums) {
    int result = Integer.MAX_VALUE;
    int curSum = 0;
    int left = 0, right = 0;

    while (right < nums.length) {
      curSum += nums[right];
      if (curSum >= target) {
        while (curSum >= target) {
          result = Math.min(result, right - left + 1);
          curSum -= nums[left++];
        }
      }

      right++;
    }

    return result == Integer.MAX_VALUE ? 0 : result;
  }

  @Test
  void test() {
    assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    assertEquals(1, minSubArrayLen(4, new int[]{1, 4, 4}));
    assertEquals(0, minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
  }
}
