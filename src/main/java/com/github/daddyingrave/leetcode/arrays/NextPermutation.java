package com.github.daddyingrave.leetcode.arrays;

public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int last = nums.length - 2;

    while (last >= 0 && nums[last] >= nums[last + 1]) {
      last--;
    }

    if (last >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[last] >= nums[j]) {
        j--;
      }
      swap(nums, last, j);
    }

    reverse(nums, last + 1, nums.length - 1);
  }

  private void swap(int[] arr, int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }

  private void reverse(int[] arr, int from, int to) {
    while (from <= to) {
      swap(arr, from++, to--);
    }
  }
}
