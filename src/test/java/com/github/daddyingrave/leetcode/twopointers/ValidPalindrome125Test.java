package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindrome125Test {

  @Test
  void isPalindrome() {
    var problem = new ValidPalindrome125();
    assertTrue(problem.isPalindrome("A man, a plan, a canal: Panama"));
    assertFalse(problem.isPalindrome("race a car"));
    assertTrue(problem.isPalindrome(" "));
  }
}
