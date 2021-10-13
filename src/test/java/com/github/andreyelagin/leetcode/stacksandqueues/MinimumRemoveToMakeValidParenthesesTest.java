package com.github.andreyelagin.leetcode.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumRemoveToMakeValidParenthesesTest {

  MinimumRemoveToMakeValidParentheses solution = new MinimumRemoveToMakeValidParentheses();
  
  @Test
  void minRemoveToMakeValid() {
    assertEquals("lee(t(c)o)de", solution.minRemoveToMakeValid("lee(t(c)o)de)"));
    assertEquals("ab(c)d", solution.minRemoveToMakeValid("a)b(c)d"));
    assertEquals("", solution.minRemoveToMakeValid("))(("));
    assertEquals("a(b(c)d)", solution.minRemoveToMakeValid("(a(b(c)d)"));
  }
}