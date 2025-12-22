package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SumofAllSubsetXORTotals1863Test {
  class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
      backtrack(0, nums, new ArrayList<>());
      return res;
    }

    void backtrack(int i, int[] nums, List<Integer> subset) {
      int xorr = 0;
      for (Integer num : subset) {
        xorr ^= num;
      }
      res += xorr;

      for (int j = i; j < nums.length; j++) {
        subset.add(nums[j]);
        backtrack(j + 1, nums, subset);
        subset.remove(subset.size() - 1);
      }
    }
  }

  @Test
  void test() {

  }
}
