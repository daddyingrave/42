package com.github.andreyelagin.leetcode.arrays;

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] merged = new int[nums1.length + nums2.length];
    
    int n1 = 0;
    int n2 = 0;
    int m = 0;
    while (n1 < nums1.length && n2 < nums2.length) {
      if (nums1[n1] <= nums2[n2]) {
        merged[m] = nums1[n1++];
      } else {
        merged[m] = nums2[n2++];
      }
      m++;
    }
    
    if (n1 < nums1.length) {
      while (n1 < nums1.length) {
        merged[m++] = nums1[n1++];
      }
    } else {
      while (n2 < nums2.length) {
        merged[m++] = nums2[n2++];
      }
    }

    int mid = merged.length / 2;
    if (merged.length % 2 == 0) {
      return ((double) (merged[mid] + merged[mid - 1])) / 2;
    } else {
      return merged[mid];
    }
  }
}
