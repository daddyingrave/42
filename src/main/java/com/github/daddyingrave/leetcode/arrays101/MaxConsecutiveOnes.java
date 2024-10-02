package com.github.daddyingrave.leetcode.arrays101;

public class MaxConsecutiveOnes {
  // 1,1,0,1,1,1
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int cur = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        max = Math.max(++cur, max);
      } else {
        cur = 0;
      }
    }

    return max;
  }
}
