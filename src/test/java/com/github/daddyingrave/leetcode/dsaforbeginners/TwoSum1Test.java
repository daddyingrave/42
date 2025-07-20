package com.github.daddyingrave.leetcode.dsaforbeginners;

import java.util.HashMap;

public class TwoSum1Test {
  public int[] twoSum(int[] nums, int target) {
    var result = new int[2];
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      Integer reminderIndex = map.get(target - nums[i]);
      if (reminderIndex != null && reminderIndex != i) {
        result[0] = i;
        result[1] = reminderIndex;
        break;
      }
    }

    return result;
  }
}
