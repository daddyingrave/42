package com.github.daddyingrave.leetcode.dsaforbeginners;

public class GuessNumberHigherOrLower374Test {
  int guess(int num) {
    return 0;
  }


  // guess: 6
  // n:     10
  public int guessNumber(int n) {
    int left = 1;
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

    return 0;
  }
}
