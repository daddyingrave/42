package com.github.daddyingrave.leetcode.sorting;

public class SortColors {
  public void sortColors(int[] nums) {
    int left = 0;
    int mid = 0;
    int right = nums.length - 1;
    
    while (left < right && mid <= right) {
      int cur = nums[mid];
      if (cur == 2) {
        swap(nums, mid, right--);
      } else if (cur == 0) {
        swap(nums, mid++, left++);
      } else {
        mid++;
      }
    }
  }

  private void swap(int[] a, int left, int right) {
    int temp = a[right];
    a[right] = a[left];
    a[left] = temp;
  }
}
