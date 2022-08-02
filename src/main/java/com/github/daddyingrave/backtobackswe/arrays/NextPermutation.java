package com.github.daddyingrave.backtobackswe.arrays;

public class NextPermutation {
  public int[] nextPermutation(int[] nums) {
    int i = nums.length - 2;
    
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    
    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
      
    }
    reverse(nums, i + 1);
    return nums;
  }

  private void swap(int[] arr, int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }

  private void reverse(int[] arr, int from) {
    int to = arr.length - 1;
    while (from < to) {
      swap(arr, from, to);
      from++;
      to--;
    }
  }
}
