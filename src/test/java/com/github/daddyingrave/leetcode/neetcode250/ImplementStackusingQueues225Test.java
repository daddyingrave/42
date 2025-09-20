package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackusingQueues225Test {
  class MyStack {
    Queue<Integer> q = new ArrayDeque<>();

    public MyStack() {
    }

    public void push(int x) {
      q.offer(x);
      int size = q.size();
      while (size > 1) {
        q.offer(q.poll());
        size--;
      }
    }

    public int pop() {
      return q.poll();
    }

    public int top() {
      return q.peek();
    }

    public boolean empty() {
      return q.isEmpty();
    }
  }

  /**
   * Your MyStack object will be instantiated and called as such:  * MyStack obj = new MyStack();  * obj.push(x);  * int param_2 = obj.pop();  * int param_3 = obj.top();  * boolean param_4 = obj.empty();
   */

  @Test
  void test() {
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    assertEquals(2, myStack.top());
    assertEquals(2, myStack.pop());
    assertFalse(myStack.empty());
  }
}
