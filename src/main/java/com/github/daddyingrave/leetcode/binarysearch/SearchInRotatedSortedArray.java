package com.github.daddyingrave.leetcode.binarysearch;

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int rotationIndex = getRotationIndex(nums);

    int left = 0;
    int right = nums.length - 1;

    if (rotationIndex >= 0) {
      if (!(target >= nums[0] && target <= nums[rotationIndex])) {
        left = rotationIndex + 1;
      }

      if (!(target >= nums[rotationIndex + 1] && target <= nums[nums.length - 1])) {
        right = rotationIndex;
      }
    }

    while (left <= right) {
      int localMid = (right - left) / 2 + left;
      if (nums[localMid] == target) {
        return localMid;
      } else if (target < nums[localMid]) {
        right = localMid - 1;
      } else {
        left = localMid + 1;
      }
    }

    return -1;
  }

  private static int getRotationIndex(int[] nums) {
    // If array is empty or has only one element, no rotation point exists
    if (nums == null || nums.length <= 1) {
      return -1;
    }

    // Special case: if array is not rotated
    if (nums[0] < nums[nums.length - 1]) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;

    // Continue while we haven't found the rotation point
    while (left < right) {
      // Calculate middle point
      int mid = left + (right - left) / 2;

      // If mid element is greater than next element,
      // we've found the rotation point
      if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
        return mid;
      }

      // If first element is less than or equal to mid element,
      // rotation point must be in right half
      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      }
      // Otherwise, rotation point must be in left half
      else {
        right = mid;
      }
    }

    // If we get here and left points to first element,
    // array was not rotated
    return (left == 0) ? -1 : left - 1;
  }
}
