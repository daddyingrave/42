package com.github.daddyingrave.leetcode.dp;

public class FibonacciNumber {
  public int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    return dp[n - 1];
  }
}
