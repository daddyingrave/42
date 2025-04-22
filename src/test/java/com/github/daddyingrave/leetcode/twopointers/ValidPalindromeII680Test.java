package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeII680Test {

  @Test
  void validPalindrome() {
    var problem = new ValidPalindromeII680();
    assertTrue(problem.validPalindrome("aba"));
    assertTrue(problem.validPalindrome("abca"));
    assertFalse(problem.validPalindrome("abc"));
    assertTrue(problem.validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu"));
  }
}
