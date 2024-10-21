package com.github.daddyingrave.leetcode.binarysearch;

public class Sqrt {
  public int mySqrt(int x) {
    int left = 0;
    int right = x;
    int candidate = 0;

    while (left <= right) {
      candidate = (right - left) / 2 + left;

      long square = (long) candidate * candidate;
      if (square == x) {
        return candidate;
      } else if (x < square) {
        right = candidate - 1;
      } else {
        left = candidate + 1;
      }
    }

    return Math.min(left, right);
  }
}
