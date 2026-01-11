package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class PartitiontoKEqualSumSubsets698Test {
  class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      nums = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
      int sum = Arrays.stream(nums).sum();
      if (sum % k != 0) {
        return false;
      }

      int target = sum / k;

      return backtrack(0, k, 0, target, nums, new boolean[nums.length]);
    }

    boolean backtrack(int i, int k, int subsetSum, int target, int[] nums, boolean[] used) {
      if (k == 0) {
        return true;
      }
      if (subsetSum == target) {
        return backtrack(0, k - 1, 0, target, nums, used);
      }

      for (int j = i; j < nums.length; j++) {
        if (used[j] || subsetSum + nums[j] > target) {
          continue;
        }
        used[j] = true;
        if (backtrack(j + 1, k, subsetSum + nums[j], target, nums, used)) {
          return true;
        }
        used[j] = false;
        if (subsetSum == 0) {
          return false;
        }
      }

      return false;
    }
  }

  @Test
  void test() {

  }
}
