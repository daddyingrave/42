package com.github.andreyelagin.leetcode.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {

  @Test
  void push() {
    var stack = new MaxStack();
    stack.push(5);
    stack.push(1);
    stack.push(5);
    assertEquals(5, stack.top());
    assertEquals(5, stack.popMax());
    assertEquals(1, stack.top());
    assertEquals(5, stack.peekMax());
    assertEquals(1, stack.pop());
    assertEquals(5, stack.top());
  }

  @Test
  void push2() {
    var stack = new MaxStack();
    stack.push(5);
    stack.push(1);
    stack.push(5);
    assertEquals(5, stack.pop());
    assertEquals(5, stack.peekMax());
    assertEquals(1, stack.top());
  }

  @Test
  void push3() {
    var stack = new MaxStack();
    stack.push(-95);
    stack.push(1);
    assertEquals(1, stack.popMax());
    stack.push(-44);
    stack.push(16);
    assertEquals(16, stack.top());
    stack.push(29);
    stack.push(65);
    stack.push(-18);
    assertEquals(-18, stack.pop());
    assertEquals(65, stack.popMax());
    assertEquals(29, stack.pop());
    stack.push(78);
  }

  @Test
  void push4() {
    var stack = new MaxStack();
    stack.push(15);
    assertEquals(15, stack.pop());
    stack.push(1);
    stack.push(-52);
    stack.push(80);
    stack.push(-39);
    assertEquals(80, stack.popMax());
    stack.push(91);
    assertEquals(91, stack.pop());
    assertEquals(-39, stack.pop());
    assertEquals(-52, stack.top());
  }
}