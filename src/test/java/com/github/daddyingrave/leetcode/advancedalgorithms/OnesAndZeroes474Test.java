package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class OnesAndZeroes474Test {
  class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
      int[][] counts = new int[strs.length][2];
      for (int i = 0; i < strs.length; i++) {
        for (char c : strs[i].toCharArray()) {
          counts[i][c - '0']++;
        }
      }

      int[][] dp = new int[m + 1][n + 1];

      for (int[] count : counts) {
        int zeros = count[0];
        int ones = count[1];
        for (int j = m; j >= zeros; j--) {
          for (int k = n; k >= ones; k--) {
            dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zeros][k - ones]);
          }
        }
      }

      return dp[m][n];
    }
  }

  @Test
  void test() {

  }
}
