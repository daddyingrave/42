package com.github.daddyingrave.leetcode.stacksandqueues;

import java.util.Map;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    var stack = new Stack<Map.Entry<Character, Integer>>();
    var sb = new StringBuilder(s);

    for (int i = 0; i < s.length(); i++) {
      var curChar = s.charAt(i);
      switch (curChar) {
        case '(':
          stack.push(Map.entry(curChar, i));
          break;
        case ')':
          if (stack.isEmpty()) {
            sb.replace(i, i + 1, "_");
          } else {
            stack.pop();
          }
          break;
        default:
          break;
      }
    }
    while (!stack.isEmpty()) {
      var paren = stack.pop();
      sb.replace(paren.getValue(), paren.getValue() + 1, "_");
    }

    return sb.toString().replace("_", "");
  }
}
