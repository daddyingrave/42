package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluateReversePolishNotation150Test {
  class Solution {
    // "4","13","5","/","+"
    public int evalRPN(String[] tokens) {
      var stack = new Stack<Integer>();

      for (String token : tokens) {
        switch (token) {
          case "+" -> stack.push(stack.pop() + stack.pop());
          case "-" -> {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left - right);
          }
          case "*" -> stack.push(stack.pop() * stack.pop());
          case "/" -> {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left / right);
          }
          default -> stack.push(Integer.valueOf(token));
        }
      }

      return stack.pop();
    }
  }

  @Test
  void test() {
    assertEquals(9, new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    assertEquals(6, new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    assertEquals(22, new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
  }
}
