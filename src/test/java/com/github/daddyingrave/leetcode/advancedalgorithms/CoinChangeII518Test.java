package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CoinChangeII518Test {
  class Solution {
    public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1;

      for (int i = coins.length - 1; i >= 0; i--) {
        int[] nextDp = new int[amount + 1];
        nextDp[0] = 1;

        for (int j = 1; j <= amount; j++) {
          nextDp[j] = dp[j];

          if (j - coins[i] >= 0) {
            nextDp[j] += nextDp[j - coins[i]];
          }
        }
        dp = nextDp;
      }

      return dp[amount];
    }
  }

  @Test
  void test() {
    assertEquals(4, new Solution().change(5, new int[]{1, 2, 5}));
  }
}
