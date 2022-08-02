package com.github.daddyingrave.leetcode.design;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
  private static final Set<String> operators = new HashSet<>();

  static {
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
  }

  public int evalRPN(String[] tokens) {
    var stack = new Stack<Integer>();

    for (String token : tokens) {
      if (operators.contains(token)) {
        int right = stack.pop();
        int left = stack.pop();
        switch (token) {
          case "+":
            stack.push(left + right);
            break;
          case "-":
            stack.push(left - right);
            break;
          case "/":
            stack.push(left / right);
            break;
          case "*":
            stack.push(left * right);
            break;
        }
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.peek();
  }
}
