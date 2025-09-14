package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstring5Test {
  class Solution {
    public String longestPalindrome(String s) {
      int maxLength = -1;
      String maxSubstring = "";

      for (int i = 0; i < s.length(); i++) {
        int left = i;
        int right = i;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
          if (right - left > maxLength) {
            maxLength = right - left;
            maxSubstring = s.substring(left, right + 1);
          }
          left--;
          right++;
        }

        left = i;
        right = i + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
          if (right - left > maxLength) {
            maxLength = right - left;
            maxSubstring = s.substring(left, right + 1);
          }
          left--;
          right++;
        }
      }

      return maxSubstring;
    }
  }

  @Test
  void test() {
    new Solution().longestPalindrome("a");
    new Solution().longestPalindrome("babad");
  }
}
