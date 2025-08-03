package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindrome125Test {
  public boolean isPalindrome(String s) {
    s = s.replaceAll(" ", "").replaceAll("\\P{Alnum}", "").toLowerCase();
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  @Test
  void test() {
    assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
  }
}
