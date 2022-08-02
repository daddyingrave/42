package com.github.daddyingrave.leetcode.dp;

public class NthTribonacciNumber {
  public int tribonacci(int n) {
    int[] dp = new int[Math.max(n, 3) + 1];
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;
    for (int i = 4; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    return dp[n];
  }
}
