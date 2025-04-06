package com.github.daddyingrave.leetcode.arrays;

public class RemoveElement27 {
  // 0,1,2,2,3,0,4,2 / 2
  public int removeElement(int[] nums, int val) {
    int border = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[border] = nums[i];
        border++;
      }
    }

    return border;
  }
}
