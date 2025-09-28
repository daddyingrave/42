package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumFrequencyStack895Test {
  class FreqStack {
    Map<Integer, Integer> counts = new HashMap<>();
    Map<Integer, Stack<Integer>> stacks = new HashMap<>();
    int currentMax = 0;

    public FreqStack() {
    }

    public void push(int val) {
      int newCount = 1 + counts.getOrDefault(val, 0);
      Stack<Integer> stack;
      if (newCount > currentMax) {
        currentMax = newCount;
        stack = new Stack<>();
        stacks.put(currentMax, stack);
      } else {
        stack = stacks.get(newCount);
      }

      counts.put(val, newCount);
      stack.push(val);
    }

    public int pop() {
      var maxStack = stacks.get(currentMax);
      int max = maxStack.pop();
      counts.put(max, counts.get(max) - 1);
      stacks.remove(currentMax);
      if (maxStack.isEmpty()) {
        currentMax--;
      }

      if (!maxStack.isEmpty()) {
        if (stacks.containsKey(currentMax)) {
          var stackToMerge = stacks.get(currentMax);
          while (!maxStack.isEmpty()) {
            stackToMerge.push(maxStack.pop());
          }
        } else {
          stacks.put(currentMax, maxStack);
        }
      }

      return max;
    }
  }

  @Test
  void test() {
    FreqStack freqStack = new FreqStack();
    freqStack.push(5); // The stack is [5]
    freqStack.push(7); // The stack is [5,7]
    freqStack.push(5); // The stack is [5,7,5]
    freqStack.push(7); // The stack is [5,7,5,7]
    freqStack.push(4); // The stack is [5,7,5,7,4]
    freqStack.push(5); // The stack is [5,7,5,7,4,5]
    assertEquals(5, freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
    assertEquals(7, freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
    assertEquals(5, freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
    assertEquals(4, freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
  }

  @Test
  void test2() {
    var stack = new FreqStack();
    stack.push(4);
    stack.push(0);
    stack.push(9);
    stack.push(3);
    stack.push(4);
    stack.push(2);
    assertEquals(4, stack.pop());
    stack.push(6);
    assertEquals(6, stack.pop());
    stack.push(1);
    assertEquals(1, stack.pop());
    stack.push(1);
    assertEquals(1, stack.pop());
    stack.push(4);
    assertEquals(4, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(3, stack.pop());
    assertEquals(9, stack.pop());
    assertEquals(0, stack.pop());
    assertEquals(4, stack.pop());
  }
}
