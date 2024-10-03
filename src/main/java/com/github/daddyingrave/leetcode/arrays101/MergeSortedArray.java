package com.github.daddyingrave.leetcode.arrays101;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] target = new int[m + n];

    int i = 0;
    int l = 0;
    int r = 0;

    while (l < m && r < n) {
      if (nums1[l] <= nums2[r]) {
        target[i] = nums1[l];
        l++;
      } else {
        target[i] = nums2[r];
        r++;
      }

      i++;
    }

    while (l < m) {
      target[i] = nums1[l];
      l++;
      i++;
    }

    while (r < n) {
      target[i] = nums2[r];
      r++;
      i++;
    }

    System.arraycopy(target, 0, nums1, 0, target.length);
  }
}
