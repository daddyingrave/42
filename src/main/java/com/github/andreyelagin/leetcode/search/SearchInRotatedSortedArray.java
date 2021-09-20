package com.github.andreyelagin.leetcode.search;

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    
    int l = 0;
    int r = nums.length - 1;
    int min = nums[0];
    
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (mid > 0 && mid < r) {
        if (!(nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1])) {
          
        }
      }
    }
    
    return -1;
  }
}
