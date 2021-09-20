package com.github.andreyelagin.leetcode.search;

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int length = nums.length;
    int shift = findStart(nums);
    int l = 0;
    int r = length - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;
      int rotatedIndex = rotatedIndex(length, shift, m);
      if (nums[rotatedIndex] == target) {
        return rotatedIndex;
      } else if (nums[rotatedIndex] > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    
    return -1;
  }

  int findStart(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (m > 0 && nums[m - 1] > nums[m]) {
        return m;
      } else if (nums[l] > nums[m]) {
        r = m - 1;
      } else if (nums[m] > nums[r]) {
        l = m + 1;
      } else if (nums[l] < nums[m]) {
        r = m - 1; // ?
      } else {
        r--;
      }
    }

    return l;
  }

  int rotatedIndex(int arrayLength, int shift, int sourceIndex) {
    return (sourceIndex + shift) % arrayLength;
  }
}
