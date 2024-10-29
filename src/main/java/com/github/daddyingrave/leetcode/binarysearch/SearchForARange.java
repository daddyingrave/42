package com.github.daddyingrave.leetcode.binarysearch;

public class SearchForARange {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }

    return new int[]{bound(nums, target, true), bound(nums, target, false)};
  }

  int bound(int[] nums, int target, boolean isLeft) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (target < nums[mid]) {
        right = mid - 1;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else if (isLeft) {
        if (mid > 0 && nums[mid - 1] != target || mid == 0) {
          return mid;
        } else {
          right = mid - 1;
        }
      } else {
        if (mid < nums.length - 1 && nums[mid + 1] != target || mid == nums.length - 1) {
          return mid;
        } else {
          left = mid + 1;
        }
      }
    }

    return -1;
  }
}
