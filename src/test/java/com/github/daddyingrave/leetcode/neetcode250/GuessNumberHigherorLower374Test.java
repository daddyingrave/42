package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

public class GuessNumberHigherorLower374Test {
  class GuessGame {
    int guess(int n) {
      return 0;
    }
  }

  public class Solution extends GuessGame {
    public int guessNumber(int n) {
      int left = 0;
      int right = n;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        int guess = guess(mid);

        if (guess == 0) {
          return mid;
        } else if (guess < 0) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return -1;
    }
  }

  @Test
  void test() {

  }
}
