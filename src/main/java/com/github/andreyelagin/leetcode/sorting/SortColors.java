package com.github.andreyelagin.leetcode.sorting;

public class SortColors {
  public void sortColors(int[] nums) {
    int left = 0;
    int mid = 0;
    int right = nums.length - 1;
    
    while (mid < right) {
      int cur = nums[mid];
      if (cur == 2) {
        swap(nums, mid, right--);
      } else if (cur == 1) {
        swap(nums, mid, left++);
      } else {
        left++;
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
