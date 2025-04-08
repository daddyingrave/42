package com.github.daddyingrave.leetcode.arrays;

public class SortColors75 {
  // 2, 0, 2, 1, 1, 0
  public void sortColors(int[] nums) {
    int reds = 0;
    int whites = 0;
    int blues = 0;

    for (int num : nums) {
      if (num == 0) {
        reds++;
      } else if (num == 1) {
        whites++;
      } else {
        blues++;
      }
    }

    int i = 0;
    while (reds > 0) {
      nums[i++] = 0;
      reds--;
    }
    while (whites > 0) {
      nums[i++] = 1;
      whites--;
    }
    while (blues > 0) {
      nums[i++] = 2;
      blues--;
    }
  }
}
