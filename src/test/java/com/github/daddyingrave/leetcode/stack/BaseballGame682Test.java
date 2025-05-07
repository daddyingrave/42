package com.github.daddyingrave.leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGame682Test {

  static final String PLUS = "+";
  static final String DOUBLE = "D";
  static final String DELETE = "C";

  public int calPoints(String[] operations) {
    var stack = new LinkedList<Integer>();

    for (String op : operations) {
      switch (op) {
        case PLUS:
          var last = stack.pop();
          var previous = stack.pop();
          var sum = last + previous;
          stack.push(previous);
          stack.push(last);
          stack.push(sum);
          break;
        case DOUBLE:
          stack.push(stack.peek() * 2);
          break;
        case DELETE:
          stack.pop();
          break;
        default:
          stack.push(Integer.parseInt(op));
      }
    }

    int result = 0;
    for (int value : stack) {
      result += value;
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(30, calPoints(new String[]{"5", "2", "C", "D", "+"}));
  }
}
