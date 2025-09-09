package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KnapsackTest {
  class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
      int[][] dp = new int[profit.size()][capacity + 1];
      for (int i = 0; i < capacity + 1; i++) {
        if (weight.get(0) <= i) {
          dp[0][i] = profit.get(0);
        }
      }

      for (int i = 1; i < profit.size(); i++) {
        for (int j = 1; j < capacity + 1; j++) {
          int ifSkip = dp[i - 1][j];
          int ifInclude = 0;
          if (j - weight.get(i) >= 0) {
            ifInclude = profit.get(i) + dp[i - 1][j - weight.get(i)];
          }
          dp[i][j] = Math.max(ifSkip, ifInclude);
        }
      }

      return dp[profit.size() - 1][capacity];
    }
  }

  @Test
  void test() {

  }
}
