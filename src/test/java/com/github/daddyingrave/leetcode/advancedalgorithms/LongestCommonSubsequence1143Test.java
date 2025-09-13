package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonSubsequence1143Test {
  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      int[] dp = new int[text1.length() + 1];

      for (int i = 0; i < text2.length(); i++) {
        int[] curDp = new int[dp.length];
        for (int j = 0; j < text1.length(); j++) {
          if (text2.charAt(i) == text1.charAt(j)) {
            curDp[j + 1] = 1 + dp[j];
          } else {
            curDp[j + 1] = Math.max(curDp[j], dp[j + 1]);
          }
        }
        dp = curDp;
      }

      return dp[dp.length - 1];
    }
  }

  @Test
  void test() {

  }
}
