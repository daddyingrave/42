package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class LargestRectangleinHistogram84Test {
  class Solution {
    public int largestRectangleArea(int[] heights) {
      record Pair(int index, int height) {
      }
      int maxArea = 0;
      var stack = new Stack<Pair>();

      for (int i = 0; i < heights.length; i++) {
        int start = i;
        while (!stack.isEmpty() && stack.peek().height > heights[i]) {
          var top = stack.pop();
          maxArea = Math.max(maxArea, top.height * (i - top.index));
          start = top.index;;
        }

        stack.push(new Pair(start, heights[i]));
      }

      for (Pair pair : stack) {
        maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
      }

      return maxArea;
    }
  }

  @Test
  void test() {

  }
}
