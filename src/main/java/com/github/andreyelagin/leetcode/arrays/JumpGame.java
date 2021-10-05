package com.github.andreyelagin.leetcode.arrays;

public class JumpGame {
  public boolean canJump(int[] nums) {
    if (nums.length == 1 && nums[0] == 0) {
      return true;
    }

    int[] dp = new int[nums.length];

    for (int i = 0; i <= nums[0] && i < nums.length; i++) {
      dp[i] = 1;
    }

    for (int i = 1; i < nums.length; i++) {
      if (dp[i] == 0) {
        return false;
      }
      int currentIndex = i + 1;
      int iterations = nums[i];
      while (currentIndex < nums.length && iterations > 0) {
        dp[currentIndex++] = 1;
        iterations--;
      }
      if (dp[dp.length - 1] == 1) {
        return true;
      }
    }

    return dp[dp.length - 1] == 1;
  }
}
