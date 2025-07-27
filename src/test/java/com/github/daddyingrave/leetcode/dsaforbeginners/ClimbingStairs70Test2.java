package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClimbingStairs70Test2 {

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 2] + dp[i - 1];
    }

    return dp[n];
  }

  @Test
  void test() {
    assertEquals(2, climbStairs(2));
    assertEquals(3, climbStairs(3));
  }
}
