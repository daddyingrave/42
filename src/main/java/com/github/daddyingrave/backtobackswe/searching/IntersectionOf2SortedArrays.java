package com.github.daddyingrave.backtobackswe.searching;

import java.util.ArrayList;

public class IntersectionOf2SortedArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    int first = 0;
    int second = 0;
    int prev = nums1[0];
    var result = new ArrayList<Integer>();
    
    while (first < nums1.length && second < nums2.length) {
      if (nums1[first] == nums2[second]) {
        if (nums1[first] != prev || result.size() == 0) {
          result.add(nums1[first]);
          prev = nums1[first];
        }
        first++;
        second++;
      } else if (nums1[first] < nums2[second]) {
        first++;
      } else {
        second++;
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
