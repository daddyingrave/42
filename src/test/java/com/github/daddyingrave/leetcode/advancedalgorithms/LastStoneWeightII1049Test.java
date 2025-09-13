package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LastStoneWeightII1049Test {
  class Solution {
    public int lastStoneWeightII(int[] stones) {
      int totalWeight = 0;
      for (int stone : stones) {
        totalWeight += stone;
      }

      int targetWeight = totalWeight / 2;
      int[] dp = new int[targetWeight + 1];

      for (int stone : stones) {
        for (int t = targetWeight; t >= stone; t--) {
          dp[t] = Math.max(dp[t], dp[t - stone] + stone);
        }
      }

      return totalWeight - 2 * dp[targetWeight];
    }
  }

  @Test
  void test() {

  }
}
