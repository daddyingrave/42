package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class PalindromicSubstrings647Test {
  class Solution {
    public int countSubstrings(String s) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
        int left = i;
        int right = i;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
          count++;
          left--;
          right++;
        }

        left = i;
        right = i + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
          count++;
          left--;
          right++;
        }
      }

      return count;
    }
  }

  @Test
  void test() {

  }
}
