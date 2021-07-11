package com.github.andreyelagin.leetcode.math;

public class CountPrimes {
  // 10
  public int countPrimes(int n) {
    boolean[] nums = new boolean[n];
    int prime = 2;
    while (prime < n) {
      for (int i = 2; i < n; i++) {
        
      }
    }
    
    int result = 0;
    for (boolean num : nums) {
      if (!num) result++;
    }
    
    return result;
  }
}
