package com.github.daddyingrave.leetcode.math;

public class Sqrt {
  public int mySqrt(int x) {
    long r = x;
    while (r * r > x) {
      r = (r + x / r) / 2;
    }
    return (int) r;
  }
}
