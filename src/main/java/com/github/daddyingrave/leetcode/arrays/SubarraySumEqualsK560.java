package com.github.daddyingrave.leetcode.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK560 {
  public int subarraySum(int[] nums, int k) {
    int result = 0;
    int curSum = 0;
    var map = new HashMap<Integer, Integer>();
    map.put(0, 1);

    for (int num : nums) {
      curSum += num;
      var prefixes = map.get(curSum - k);
      if (prefixes != null) {
        result += prefixes;
      }

      map.compute(curSum, (l, r) -> r == null ? 1 : r + 1);
    }

    return result;
  }
}
