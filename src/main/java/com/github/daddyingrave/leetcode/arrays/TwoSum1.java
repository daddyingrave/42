package com.github.daddyingrave.leetcode.arrays;

import java.util.HashMap;

public class TwoSum1 {
  public int[] twoSum(int[] nums, int target) {
    var indexes = new HashMap<Integer, Integer>();
    var indexesToReturn = new int[2];

    for (int i = 0; i < nums.length; i++) {
      var addUpIndex = indexes.get(target - nums[i]);
      if (addUpIndex != null && addUpIndex != i) {
        indexesToReturn[0] = i;
        indexesToReturn[1] = addUpIndex;
        return indexesToReturn;
      } else {
        indexes.put(nums[i], i);
      }
    }

    return null;
  }
}
