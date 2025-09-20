package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowMaximum239Test {
  class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      var deque = new ArrayDeque<Integer>();
      int left = 0;
      int right = 0;
      int[] result = new int[nums.length - k + 1];

      while (right < nums.length) {
        while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
          deque.removeLast();
        }

        deque.addLast(right);

        if (left > deque.getFirst()) {
          deque.removeFirst();
        }

        if (right + 1 >= k) {
          result[left] = nums[deque.getFirst()];
          left++;
        }

        right++;
      }

      return result;
    }
  }

  @Test
  void test() {
    assertArrayEquals(
        new int[]{3, 3, 5, 5, 6, 7},
        new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)
    );
    assertArrayEquals(
        new int[]{1},
        new Solution().maxSlidingWindow(new int[]{1}, 1)
    );
  }
}
