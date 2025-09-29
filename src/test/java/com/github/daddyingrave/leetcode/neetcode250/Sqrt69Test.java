package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Sqrt69Test {
  class Solution {
    public int mySqrt(int x) {
      int left = 1;
      int right = x;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        double square = (double) mid * mid;
        if (square == x) {
          return mid;
        } else if (square > x) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return right;
    }
  }

  @Test
  void test() {
    assertEquals(2, new Solution().mySqrt(4));
    assertEquals(2, new Solution().mySqrt(8));
    assertEquals(46339, new Solution().mySqrt(2147395599));
  }
}
