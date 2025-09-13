package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets983Test {
  class Solution {
    public int mincostTickets(int[] days, int[] costs) {
      var daysCosts = new HashMap<Integer, Integer>();
      daysCosts.put(1, costs[0]);
      daysCosts.put(7, costs[1]);
      daysCosts.put(30, costs[2]);

      int[] dp = new int[days.length + 1];

      for (int i = days.length - 1; i >= 0; i--) {
        int j = i;
        dp[i] = Integer.MAX_VALUE;
        for (var dayCost : daysCosts.entrySet()) {
          while (j < days.length && days[j] < days[i] + dayCost.getKey()) {
            j++;
          }
          dp[i] = Math.min(dp[i], dayCost.getValue() + dp[j]);
        }
      }

      return dp[0];
    }
  }

  @Test
  void test() {

  }
}
