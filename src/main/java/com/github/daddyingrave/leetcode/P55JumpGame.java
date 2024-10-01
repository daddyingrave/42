package com.github.daddyingrave.leetcode;

public class P55JumpGame {
  // 3, 2, 1, 0, 4
  public boolean canJump(int[] nums) {
    int latest = nums.length - 1;
    int i = nums.length - 2;

    while (i >= 0) {
      if (nums[i] + i >= latest) {
        latest = i;
      }

      i--;
    }

    return nums[i + 1] >= latest;
  }
}
