package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

public class PalindromeNumber9Test {
  class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      }

      long tmp = x;
      long reversed = 0;

      while (tmp > 0) {
        int curDigit = (int) tmp % 10;
        reversed = reversed * 10 + curDigit;
        tmp /= 10;
      }

      return reversed == x;
    }
  }

  @Test
  void test() {

  }
}
