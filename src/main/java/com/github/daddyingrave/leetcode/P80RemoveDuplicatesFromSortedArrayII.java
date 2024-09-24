package com.github.daddyingrave.leetcode;

public class P80RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int occurrences = 1;
    int last = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        occurrences = 1;
        nums[last++] = nums[i];
      } else if (nums[i] == nums[i - 1] && occurrences < 2) {
        occurrences++;
        nums[last++] = nums[i];
      }
    }

    return last;
  }
}
