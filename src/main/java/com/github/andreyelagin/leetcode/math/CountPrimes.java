package com.github.andreyelagin.leetcode.math;

public class CountPrimes {
  public int countPrimes(int n) {
    if (n <= 2) {
      return 0;
    }
    boolean[] nums = new boolean[n];

    int prime = 2;
    while (prime <= (int) Math.sqrt(n)) {
      if (!nums[prime]) {
        for (int i = prime * prime; i < n; i += prime) {
          nums[i] = true;
        }
      }
      prime++;
    }

    int result = 0;
    for (int i = 2; i < nums.length; i++) {
      if (!nums[i]) result++;
    }

    return result;
  }
}
