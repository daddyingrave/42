package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackUsingQueues225Test {
  class MyStack {

    private final Queue<Integer> q1 = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
      q1.offer(x);
      int l = q1.size();
      while (l > 1) {
        q1.offer(q1.poll());
        l--;
      }
    }

    public int pop() {
      return q1.poll();
    }

    public int top() {
      return q1.peek();
    }

    public boolean empty() {
      return q1.isEmpty();
    }
  }

  @Test
  void test() {
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    assertEquals(2, myStack.top());
    assertEquals(2, myStack.pop());
    assertFalse(myStack.empty());
  }

  @Test
  void test2() {
    MyStack myStack = new MyStack();
    myStack.push(1);
    assertEquals(1, myStack.pop());
    assertTrue(myStack.empty());
  }

  @Test
  void test3() {
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    assertEquals(2, myStack.pop());
    assertEquals(1, myStack.top());
  }

  @Test
  void test4() {
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    assertEquals(3, myStack.pop());
    assertEquals(2, myStack.pop());
    assertEquals(1, myStack.pop());
    assertTrue(myStack.empty());
  }
}
