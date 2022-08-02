package com.github.daddyingrave.leetcode.strings;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    var longest = s.substring(0, 1);

    for (int i = 0; i < s.length(); i++) {
      if (longest.length() > s.length() - i) {
        break;
      }
      int rb = s.length() - 1;
      int l = i;
      int r = s.length() - 1;
      boolean matched = false;
      while (l <= r) {
        if (s.charAt(l) == s.charAt(r)) {
          matched = true;
          l++;
          r--;
          if (l >= r) {
            if (longest.length() < rb - i + 1) {
              longest = s.substring(i, rb + 1);
            }
          }
        } else {
          if (matched) {
            matched = false;
            r = rb - 1;
          } else {
            r--;
          }
          
          l = i;
          rb = r;
        }
      }
    }

    return longest;
  }
}
