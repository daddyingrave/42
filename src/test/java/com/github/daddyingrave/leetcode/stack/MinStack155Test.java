package com.github.daddyingrave.leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MinStack155Test {
  class MinStack {

    private final LinkedList<Node> stack = new LinkedList<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
      this.min = Math.min(val, this.min);

      var node = new Node();
      node.val = val;
      node.min = this.min;

      stack.push(node);
    }

    public void pop() {
      this.stack.pop();
      if (!stack.isEmpty()) {
        min = stack.peek().min;
      } else {
        min = Integer.MAX_VALUE;
      }
    }

    public int top() {
      return stack.peek().val;
    }

    public int getMin() {
      return this.min;
    }

    static class Node {
      int val;
      int min;
    }
  }

  @Test
  void test() {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assertEquals(-3, minStack.getMin());
    minStack.pop();
    assertEquals(0, minStack.top());
    assertEquals(-2, minStack.getMin());
  }
}
