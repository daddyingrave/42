package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class AsteroidCollision735Test {
  class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      var stack = new Stack<Integer>();

      for (int asteroid : asteroids) {
        while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
          int diff = asteroid + stack.peek();
          if (diff < 0) {
            stack.pop();
          } else if (diff > 0) {
            asteroid = 0;
          } else {
            asteroid = 0;
            stack.pop();
          }
        }

        if (asteroid != 0) {
          stack.push(asteroid);
        }
      }


      int[] result = new int[stack.size()];
      for (int i = result.length - 1; i >= 0; i--) {
        result[i] = stack.pop();
      }

      return result;
    }
  }

  @Test
  void test() {
    assertArrayEquals(new int[]{5, 10}, new Solution().asteroidCollision(new int[]{5, 10, -5}));
    assertArrayEquals(new int[]{}, new Solution().asteroidCollision(new int[]{8, -8}));
    assertArrayEquals(new int[]{10}, new Solution().asteroidCollision(new int[]{10, 2, -5}));
    assertArrayEquals(new int[]{-2, -1, 1, 2}, new Solution().asteroidCollision(new int[]{-2, -1, 1, 2}));
  }
}
