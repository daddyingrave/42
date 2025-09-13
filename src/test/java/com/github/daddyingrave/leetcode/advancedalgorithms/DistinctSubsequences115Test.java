package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistinctSubsequences115Test {
  class Solution {
    public int numDistinct(String s, String t) {
      int sourceLength = s.length();
      int targetLength = t.length();

      int[] dp = new int[targetLength + 1];

      dp[targetLength] = 1;
      for (int i = sourceLength - 1; i >= 0; i--) {
        int prev = 1;
        for (int j = targetLength - 1; j >= 0; j--) {
          int res = dp[j];
          if (s.charAt(i) == t.charAt(j)) {
            res += prev;
          }

          prev = dp[j];
          dp[j] = res;
        }
      }

      return dp[0];
    }
  }

  @Test
  void test() {

  }
}
