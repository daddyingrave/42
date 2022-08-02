package com.github.daddyingrave.leetcode.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

  ValidParentheses solution = new ValidParentheses();
  
  @Test
  void isValid() {
    assertTrue(solution.isValid("()"));
    assertTrue(solution.isValid("()[]{}"));
    assertTrue(solution.isValid("{[]}"));
    assertFalse(solution.isValid("(]"));
    assertFalse(solution.isValid("([)]"));
  }
}