package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    
    int prev = lower - 1;
    for (int i = 0; i <= nums.length; i++) {
      int curr = (i < nums.length) ? nums[i] : upper + 1;
      if (prev + 1 <= curr - 1) {
        result.add(rangeToString(prev + 1, curr - 1));
      }
      prev = curr;
    }
    
    return result;
  }

  private String rangeToString(int lower, int upper) {
    if (lower == upper) {
      return String.format("%d", lower);
    } else {
      return String.format("%d->%d", lower, upper);
    }
  }
}
