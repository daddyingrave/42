package com.github.daddyingrave.leetcode.strings;

public class ReverseString {
  public void reverseString(char[] s) {
    int last = s.length - 1;
    for (int i = 0; i < s.length / 2; i++) {
      char temp = s[last - i];
      s[last - i] = s[i];
      s[i] = temp;
    }
  }
}
