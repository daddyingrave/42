package com.github.daddyingrave.leetcode;

class P88MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] result = new int[m + n];

    var n1Index = 0;
    var n2Index = 0;
    var globalIndex = 0;

    while (n1Index < m && n2Index < n) {
      if (nums1[n1Index] <= nums2[n2Index]) {
        result[globalIndex] = nums1[n1Index];
        n1Index++;
      } else {
        result[globalIndex] = nums2[n2Index];
        n2Index++;
      }

      globalIndex++;
    }

    if (n1Index < m) {
      for (int i = n1Index; i < nums1.length && globalIndex < result.length; i++) {
        result[globalIndex++] = nums1[i];
      }
    }

    if (n2Index < n) {
      for (int i = n2Index; i < nums2.length && globalIndex < result.length; i++) {
        result[globalIndex++] = nums2[i];
      }
    }

    for (int i = 0; i < result.length; i++) {
      nums1[i] = result[i];
    }
  }
}
