package com.github.daddyingrave.leetcode.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence128 {
  // 100,4,200,1,3,2
  public int longestConsecutive(int[] nums) {
    var set = new HashSet<Integer>();
    int maxLength = 0;

    for (int num : nums) {
      set.add(num);
    }

    for (int num : set) {
      if (!set.contains(num - 1)) {
        int curLength = 1;
        while (set.contains(num + curLength)) {
          curLength++;
        }
        maxLength = Math.max(maxLength, curLength);
      }
    }

    return maxLength;
  }
}
