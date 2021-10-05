package com.github.andreyelagin.leetcode.arrays;

public class JumpGame {
  public boolean canJump(int[] nums) {
    return traverse(nums, 0);
  }

  private boolean traverse(int[] nums, int index) {
    if (index >= nums.length - 1) {
      return true;
    } else if (nums[index] == 0) {
      return false;
    }

    return traverse(nums, index + nums[index]--) || traverse(nums, index + nums[index]);
  }
}
