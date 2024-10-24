package com.github.daddyingrave.leetcode.binarysearch;

public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
        if (mid > 0 && nums[mid] > nums[mid - 1]) {
          return mid;
        } else {
          right = mid - 1;
        }
      } else {
        left = mid + 1;
      }

    }

    return left;
  }
}
