package com.github.daddyingrave.leetcode.binarysearch;

public class GuessNumberHigherOrLower {
  public int guessNumber(int n) {
    int left = 0;
    int right = n;

    while (left <= right) {
      int mid = (right - left) / 2 + left;
      int guess = guess(mid);
      if (guess == 0) {
        return mid;
      } else if (guess == 1) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return -1;
  }

  int guess(int num) {
    return 0;
  }
}
