package com.github.daddyingrave.leetcode.arrays;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] a, b;
    if (nums1.length > nums2.length) {
      a = nums2;
      b = nums1;
    } else {
      a = nums1;
      b = nums2;
    }

    int half = (a.length + b.length) / 2;
    int left = 0;
    int right = a.length - 1;

    while (true) {
      int leftMid = Math.floorDiv(left + right, 2);
      int rightMid = half - leftMid - 2;

      double aLeft = leftMid >= 0 ? a[leftMid] : NEGATIVE_INFINITY;
      double aRight = (leftMid + 1) < a.length ? a[leftMid + 1] : POSITIVE_INFINITY;
      double bLeft = rightMid >= 0 ? b[rightMid] : NEGATIVE_INFINITY;
      double bRight = (rightMid + 1) < b.length ? b[rightMid + 1] : POSITIVE_INFINITY;

      if (aLeft <= bRight && bLeft <= aRight) {
        if ((a.length + b.length) % 2 == 0) {
          return ((Math.max(aLeft, bLeft) + Math.min(aRight, bRight))) / 2;
        } else {
          return Math.min(aRight, bRight);
        }
      } else if (aLeft > bRight) {
        right = leftMid - 1;
      } else {
        left = leftMid + 1;
      }
    }
  }
}
