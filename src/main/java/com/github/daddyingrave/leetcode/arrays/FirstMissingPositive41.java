package com.github.daddyingrave.leetcode.arrays;

public class FirstMissingPositive41 {
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        nums[i] = 0;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      int elem = Math.abs(nums[i]);
      if (elem != 0 && elem <= nums.length) {
        if (nums[elem - 1] == 0) {
          nums[elem - 1] = -(nums.length + 1);
        } else {
          nums[elem - 1] = -Math.abs(nums[elem - 1]);
        }
      }
    }

    for (int i = 1; i <= nums.length; i++) {
      if (nums[i - 1] >= 0) {
        return i;
      }
    }


    return nums.length + 1;
  }
}
