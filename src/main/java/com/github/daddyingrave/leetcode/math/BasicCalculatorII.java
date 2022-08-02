package com.github.daddyingrave.leetcode.math;

import java.util.Set;
import java.util.Stack;

public class BasicCalculatorII {
  private static final Set<Character> supportedOperations = Set.of('+', '-', '/', '*');

  public int calculate(String s) {
    var ops = new Stack<Character>();
    var numbers = new Stack<Integer>();

    boolean execute = false;
    int i = 0;
    while (i < s.length()) {
      char term = s.charAt(i);
      if (term == ' ') {
        i++;
        continue;
      }

      if (supportedOperations.contains(term)) {
        if (term == '*' || term == '/') {
          execute = true;
        }
        ops.push(term);
        i++;
        continue;
      }

      int k = 0;
      while (Character.isDigit(term)) {
        k = k * 10 + term - '0';
        if (++i == s.length()) {
          break;
        }
        term = s.charAt(i);
      }

      if (execute) {
        numbers.push(execute(ops.pop(), numbers.pop(), k));
        execute = false;
      } else {
        numbers.push(k);
      }
    }

    var opsReversed = new Stack<Character>();
    var numsReversed = new Stack<Integer>();
    reverseStack(ops, opsReversed);
    reverseStack(numbers, numsReversed);
    
    while (numsReversed.size() > 1) {
      numsReversed.push(execute(opsReversed.pop(), numsReversed.pop(), numsReversed.pop()));
    }

    return numsReversed.pop();
  }
  
  private <T> void reverseStack(Stack<T> from, Stack<T> to) {
    while (!from.isEmpty()) {
      to.push(from.pop());
    }
  }

  private int execute(char op, int left, int right) {
    int result = 0;
    switch (op) {
      case '+':
        result = left + right;
        break;
      case '-':
        result = left - right;
        break;
      case '/':
        result = left / right;
        break;
      case '*':
        result = left * right;
        break;
    }
    
    return result;
  }
}
