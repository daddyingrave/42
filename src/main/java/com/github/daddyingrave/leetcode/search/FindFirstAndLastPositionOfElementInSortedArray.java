package com.github.daddyingrave.leetcode.search;

public class FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }

    int[] res = new int[2];
    res[0] = boundaries(nums, target, true);
    res[1] = boundaries(nums, target, false);
    
    return res;
  }

  private int boundaries(int[] arr, int target, boolean left) {
    int l = 0;
    int r = arr.length - 1;
    
    while (l <= r) {
      int mid = ((r - l) / 2) + l;
      if (target == arr[mid]) {
        if (left) {
          if (mid == 0 || arr[mid - 1] != target) {
            return mid;
          } else {
            r = mid - 1;
          }
        } else {
          if (mid == arr.length - 1 || arr[mid + 1] != target) {
            return mid;
          } else {
            l = mid + 1;
          }
        }
      } else if (target < arr[mid]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    
    return -1;
  }
}
