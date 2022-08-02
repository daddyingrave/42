package com.github.daddyingrave.backtobackswe.searching;

public class MinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int mid;
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      mid = l + ((r - l) / 2);
      if (nums[mid] > nums[r]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }

    return nums.length > 0 ? nums[l] : -1;
  }
}
