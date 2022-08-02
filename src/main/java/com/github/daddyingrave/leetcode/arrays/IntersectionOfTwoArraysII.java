package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysII {
  public int[] intersect(int[] nums1, int[] nums2) {
    var result = new ArrayList<Integer>();

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    int first = 0;
    int second = 0;
    
    while (first < nums1.length && second < nums2.length) {
      if (nums1[first] < nums2[second]) {
        first++;
      } else if (nums1[first] > nums2[second]) {
        second++;
      } else {
        result.add(nums1[first]);
        first++;
        second++;
      }
    }
    
    return result.stream().mapToInt(Integer::valueOf).toArray();
  }
}
