package com.github.daddyingrave.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    var set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }
    
    return false;
  }

  // much faster
  public boolean containsDuplicateSorted(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }

    return false;
  }
}
