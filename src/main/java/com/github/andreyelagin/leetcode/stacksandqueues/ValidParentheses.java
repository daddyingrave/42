package com.github.andreyelagin.leetcode.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  private static final Map<Character, Character> parentheses = new HashMap<>();
  static {
    parentheses.put(')', '(');
    parentheses.put('}', '{');
    parentheses.put(']', '[');
  }
  
  public boolean isValid(String s) {
    var stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      var curChar = s.charAt(i);
      switch (curChar) {
        case '(':
        case '[':
        case '{':
          stack.push(curChar);
          break;
        default:
          if (stack.isEmpty()) {
            return false;
          }
          var last = stack.pop();
          if (last != parentheses.get(curChar)) {
            return false;
          }
          break;
      }
    }
    
    return stack.isEmpty();
  }
}
