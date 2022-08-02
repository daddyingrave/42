package com.github.daddyingrave.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeIITest {

  ValidPalindromeII solution = new ValidPalindromeII();
  
  @Test
  void validPalindrome() {
    assertTrue(solution.validPalindrome("aba"));
    assertTrue(solution.validPalindrome("abca"));
    assertTrue(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    assertFalse(solution.validPalindrome("abc"));
    assertFalse(solution.validPalindrome("abdc"));
  }
}