package com.github.andreyelagin.backtobackswe.searching;

import java.util.HashMap;

public class FourSum {
  public int fourSum(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    var sums12 = new HashMap<Integer, Integer>();

    for (int i1 : nums1) {
      for (int i2 : nums2) {
        var sum = i1 + i2;
        sums12.put(sum, sums12.getOrDefault(sum, 0) + 1);
      }
    }

    int ans = 0;
    for (int i3 : nums3) {
      for (int i4 : nums4) {
        ans += sums12.getOrDefault(-1 * (i3 + i4), 0);
      }
    }

    return ans;
  }
}
