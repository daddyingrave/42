package com.github.daddyingrave.leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ValidParentheses20Test {
  public boolean isValid(String s) {
    var stack = new LinkedList<Character>();

    for (char c : s.toCharArray()) {
      switch (c) {
        case '(', '{', '[':
          stack.push(c);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') {
            return false;
          }
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') {
            return false;
          }
          break;
        default:
          return false;
      }
    }

    return stack.isEmpty();
  }

  @Test
  void test() {
    assertTrue(isValid("()"));
    assertTrue(isValid("()[]{}"));
    assertFalse(isValid("(]"));
    assertTrue(isValid("([])"));
  }
}
