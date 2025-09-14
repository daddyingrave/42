package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class ShortestCommonSupersequence1092Test {
  class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
      int N = str1.length();
      int str2Len = str2.length();

      String[] prev = new String[str2Len + 1];
      for (int i = prev.length - 1; i >= 0; i--) {
        prev[i] = str2.substring(i);
      }

      for (int i = N - 1; i >= 0; i--) {
        String[] cur = new String[str2Len + 1];
        cur[cur.length - 1] = str1.substring(i);

        for (int j = str2Len - 1; j >= 0; j--) {
          if (str1.charAt(i) == str2.charAt(j)) {
            cur[j] = "%s%s".formatted(str1.charAt(i), prev[j + 1]);
          } else {
            String str1Cut = "%s%s".formatted(str1.charAt(i), prev[j]);
            String str2Cut = "%s%s".formatted(str2.charAt(j), cur[j + 1]);
            if (str1Cut.length() < str2Cut.length()) {
              cur[j] = str1Cut;
            } else {
              cur[j] = str2Cut;
            }
          }
        }

        prev = cur;
      }

      return prev[0];
    }
  }

  @Test
  void test() {
    new Solution().shortestCommonSupersequence("abac", "cab");
  }
}

