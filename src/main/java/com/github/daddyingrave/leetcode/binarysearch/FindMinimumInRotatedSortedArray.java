package com.github.daddyingrave.leetcode.binarysearch;

public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }

      // 5, 1, 2, 3, 4
      if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
        right = mid;
      } else if (nums[left] > nums[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }
}
