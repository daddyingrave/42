package com.github.daddyingrave.leetcode.arrays101;

public class FindNumbersWithEvenNumberOfDigits {
  public int findNumbers(int[] nums) {
    int evenCount = 0;

    for (int num : nums) {
      if (countDigits(num) % 2 == 0) {
        evenCount++;
      }
    }

    return evenCount;
  }

  private int countDigits(int num) {
    if (num == 0) {
      return 1;
    }

    int count = 0;

    while (num != 0) {
      num /= 10;
      count++;
    }

    return count;
  }
}
