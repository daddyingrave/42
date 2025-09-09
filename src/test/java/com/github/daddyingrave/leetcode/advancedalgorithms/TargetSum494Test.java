package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TargetSum494Test {
  class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      var dp = new HashMap<Integer, Map<Integer, Integer>>();
      for (int i = 0; i <= nums.length; i++) {
        dp.put(i, new HashMap<>());
      }

      dp.get(0).put(0, 1);

      for (int i = 0; i < nums.length; i++) {
        for (var counts : dp.get(i).entrySet()) {
          int total = counts.getKey();
          int count = counts.getValue();

          dp.get(i + 1).put(total + nums[i], dp.get(i + 1).getOrDefault(total + nums[i], 0) + count);
          dp.get(i + 1).put(total - nums[i], dp.get(i + 1).getOrDefault(total - nums[i], 0) + count);
        }
      }

      return dp.get(nums.length).getOrDefault(target, 0);
    }
  }

  @Test
  void test() {

  }
}
