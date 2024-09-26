package com.github.daddyingrave.leetcode;

public class P189RotateArray {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n; // In case k > n

    // Reverse the entire array
    reverse(nums, 0, n - 1);

    // Reverse the first k elements
    reverse(nums, 0, k - 1);

    // Reverse the remaining n-k elements
    reverse(nums, k, n - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public void rotate2(int[] nums, int k) {
    int[] copy = new int[nums.length];
    System.arraycopy(nums, 0, copy, 0, nums.length);

    for (int i = 0; i < copy.length; i++) {
      int targetIndex = i + k;

      if (targetIndex >= copy.length) {
        targetIndex = targetIndex % copy.length;
      }

      nums[targetIndex] = copy[i];
    }
  }
}
