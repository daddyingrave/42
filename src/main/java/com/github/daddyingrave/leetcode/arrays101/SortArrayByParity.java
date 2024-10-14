package com.github.daddyingrave.leetcode.arrays101;

public class SortArrayByParity {
  public int[] sortArrayByParity(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      while (right > left && nums[right] % 2 != 0) {
        right--;
      }

      while (left < right && nums[left] % 2 == 0) {
        left++;
      }

      int tmp = nums[right];
      nums[right] = nums[left];
      nums[left] = tmp;
    }

    return nums;
  }
}
