package com.github.andreyelagin.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

  LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
  
  @Test
  void longestPalindrome() {
    assertEquals("bab", solution.longestPalindrome("babad"));
    assertEquals("bb", solution.longestPalindrome("cbbd"));
    assertEquals("a", solution.longestPalindrome("a"));
    assertEquals("a", solution.longestPalindrome("ac"));
    assertEquals("bacab", solution.longestPalindrome("bacabab"));
    assertEquals("aaabaaa", solution.longestPalindrome("aaabaaaa"));
  }
}