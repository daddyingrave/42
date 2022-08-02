package com.github.daddyingrave.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeConstructionTest {

  LongestPalindromeConstruction longestPalindrome = new LongestPalindromeConstruction();

  @Test
  void longestPalindrome() {
    assertEquals(5, longestPalindrome.longestPalindrome("aabbc"));
    assertEquals(5, longestPalindrome.longestPalindrome("abbcccd"));
    assertEquals(1, longestPalindrome.longestPalindrome("aA"));
    assertEquals(1, longestPalindrome.longestPalindrome("xyz"));
    assertEquals(3, longestPalindrome.longestPalindrome("ccc"));
    assertEquals(
        51,
        longestPalindrome.longestPalindrome(
            "aaaaabbbbbyyyyyuuuuukkkkklllllfffffrrrrrwwwwwpppppqqqqqabcdefgh"
        )
    );
  }
}