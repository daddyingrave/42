package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementQueueusingStacks232Test {
  class MyQueue {
    Stack<Integer> push = new Stack<>();
    Stack<Integer> pop = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
      push.push(x);
    }

    public int pop() {
      if (pop.isEmpty()) {
        while (!push.isEmpty()) {
          pop.push(push.pop());
        }
      }

      return pop.pop();
    }

    public int peek() {
      if (pop.isEmpty()) {
        while (!push.isEmpty()) {
          pop.push(push.pop());
        }
      }

      return pop.peek();
    }

    public boolean empty() {
      return push.isEmpty() && pop.isEmpty();
    }
  }

  /**
   * Your MyQueue object will be instantiated and called as such:
   * MyQueue obj = new MyQueue();
   * obj.push(x);
   * int param_2 = obj.pop();
   * int param_3 = obj.peek();
   * boolean param_4 = obj.empty();
   */

  @Test
  void test() {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    assertEquals(1, myQueue.peek());
    assertEquals(1, myQueue.pop());
    assertFalse(myQueue.empty());
  }
}
