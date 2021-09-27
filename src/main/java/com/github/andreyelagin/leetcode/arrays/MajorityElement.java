package com.github.andreyelagin.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
  public int majorityElement(int[] nums) {
    var hashTable = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      hashTable.compute(nums[i], (k, v) -> v == null ? 1 : ++v);
    }

    Map.Entry<Integer, Integer> max = null;
    for (Map.Entry<Integer, Integer> entry : hashTable.entrySet()) {
      if (max == null) {
        max = entry;
      } else {
        max = entry.getValue() > max.getValue() ? entry : max;
      }
    }

    return max.getKey();
  }
}
