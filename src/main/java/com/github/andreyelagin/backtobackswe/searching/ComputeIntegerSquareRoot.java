package com.github.andreyelagin.backtobackswe.searching;

public class ComputeIntegerSquareRoot {
  public int squareRoot(int n) {
    int bottom = 1;
    int top = n;
    int result = 1;

    while (bottom <= top) {
      long mid = bottom + ((top - bottom) / 2);
      if (mid * mid <= (long) n) {
        result = (int) mid;
        bottom = (int) mid + 1;
      } else {
        top = (int) mid - 1;
      }
    }

    return result;
  }
}
