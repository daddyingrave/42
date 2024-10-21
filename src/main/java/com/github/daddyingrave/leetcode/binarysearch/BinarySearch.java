package com.github.daddyingrave.leetcode.binarysearch;

public class BinarySearch {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;


    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (nums[mid] == target) {
        return mid;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }
}
