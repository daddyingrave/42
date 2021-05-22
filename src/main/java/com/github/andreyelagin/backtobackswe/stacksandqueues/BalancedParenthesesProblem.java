package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParenthesesProblem {
  public boolean isValid(String s) {
    var mappings = new HashMap<Character, Character>();
    mappings.put(')', '(');
    mappings.put(']', '[');
    mappings.put('}', '{');
    var stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      var cur = s.charAt(i);
      if (mappings.containsKey(cur)) {
        if (stack.empty()) {
          return false;
        }
        if (mappings.get(cur) != stack.pop()) {
          return false;
        }
      } else {
        stack.push(cur);
      }
    }

    return stack.empty();
  }

  public boolean isValidMy(String s) {
    var stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      var p = s.charAt(i);
      switch (p) {
        case '(':
        case '[':
        case '{':
          stack.push(p);
          break;
        case ')':
        case ']':
        case '}':
          if (stack.empty()) {
            return false;
          }
          var cur = stack.pop();
          if (!corresponds(p, cur)) {
            return false;
          }
      }
    }

    return stack.empty();
  }

  private boolean corresponds(char given, char previous) {
    var matched = false;
    switch (given) {
      case ')':
        matched = previous == '(';
        break;
      case ']':
        matched = previous == '[';
        break;
      case '}':
        matched = previous == '{';
        break;
    }

    return matched;
  }
}
