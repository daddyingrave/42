package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class PartitionEqualSubsetSum416Test {
  class Solution {
    public boolean canPartition(int[] nums) {
      int arraySum = 0;
      for (int num : nums) {
        arraySum += num;
      }

      if (arraySum % 2 == 1) {
        return false;
      }

      int target = arraySum / 2;

      var dp = new HashSet<Integer>();
      for (int i = nums.length - 1; i >= 0; i--) {
        var intermediateSums = new HashSet<Integer>();
        intermediateSums.add(nums[i]);
        for (Integer sum : dp) {
          intermediateSums.add(nums[i] + sum);
        }

        dp.addAll(intermediateSums);
      }

      return dp.contains(target);
    }
  }

  @Test
  void test() {

  }
}
