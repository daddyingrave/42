package com.github.daddyingrave.leetcode.arrays101;

public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int last = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[last] = nums[i];
        last++;
      }
    }

    return last;
  }
}
