package com.github.daddyingrave.leetcode.arrays101;

public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int last = nums.length - 1;
    int cur = 0;

    while (cur <= last) {
      if (nums[cur] == val) {
        nums[cur] = nums[last];
        nums[last] = 0;
        last--;
      } else {
        cur++;
      }
    }

    return cur;
  }
}
