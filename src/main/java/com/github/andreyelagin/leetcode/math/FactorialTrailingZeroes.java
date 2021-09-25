package com.github.andreyelagin.leetcode.math;

public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int count = 0;
    
    while (n != 0) {
      int tmp = n / 5;
      count += tmp;
      n = tmp;
    }
    
    return count;
  }
}
