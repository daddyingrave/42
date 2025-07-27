package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonSubsequence1143 {
  public int longestCommonSubsequence(String text1, String text2) {
    int rows = text1.length();
    int cols = text2.length();
    int[][] dp = new int[rows][cols];

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        if (text1.charAt(i) == text2.charAt(j)) {
          if (i + 1 < rows && j + 1 < cols) {
            dp[i][j] = dp[i + 1][j + 1] + 1;
          } else {
            dp[i][j] = 1;
          }
        } else {
          int right = 0;
          int bottom = 0;
          if (j + 1 < cols) {
            right = dp[i][j + 1];
          }
          if (i + 1 < rows) {
            bottom = dp[i + 1][j];
          }
          dp[i][j] = Math.max(right, bottom);
        }
      }
    }

    return dp[0][0];
  }

  @Test
  void test() {
    assertEquals(3, longestCommonSubsequence("abcde", "ace"));
    assertEquals(3, longestCommonSubsequence("abc", "abc"));
    assertEquals(0, longestCommonSubsequence("abc", "def"));
  }
}
