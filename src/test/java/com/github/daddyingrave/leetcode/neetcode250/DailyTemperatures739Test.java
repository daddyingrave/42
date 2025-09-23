package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class DailyTemperatures739Test {
  class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      record Tuple(int temp, int i) {
      }
      var stack = new Stack<Tuple>();
      int[] result = new int[temperatures.length];

      for (int i = 0; i < temperatures.length; i++) {
        while (!stack.isEmpty() && stack.peek().temp < temperatures[i]) {
          Tuple pop = stack.pop();
          result[pop.i] = i - pop.i;
        }

        stack.push(new Tuple(temperatures[i], i));
      }

      return result;
    }
  }

  @Test
  void test() {
    assertArrayEquals(
        new int[]{1, 1, 4, 2, 1, 1, 0, 0},
        new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})
    );
    assertArrayEquals(
        new int[]{1, 1, 1, 0},
        new Solution().dailyTemperatures(new int[]{30, 40, 50, 60})
    );
    assertArrayEquals(
        new int[]{1, 1, 0},
        new Solution().dailyTemperatures(new int[]{30, 60, 90})
    );
  }
}
