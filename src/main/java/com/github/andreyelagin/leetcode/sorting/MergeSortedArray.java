package com.github.andreyelagin.leetcode.sorting;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] temp = new int[m + n];
    int cur = 0;
    int n1 = 0;
    int n2 = 0;

    while (n1 < m && n2 < n) {
      if (nums1[n1] <= nums2[n2]) {
        temp[cur++] = nums1[n1++];
      } else {
        temp[cur++] = nums2[n2++];
      }
    }
    
    while (n1 < m) {
      temp[cur++] = nums1[n1++];
    }
    while (n2 < n) {
      temp[cur++] = nums2[n2++];
    }
    
    System.arraycopy(temp, 0, nums1, 0, m + n);
  }
}
