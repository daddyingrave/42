package com.github.andreyelagin.leetcode.strings;

public class ReverseStringRec {
  public void reverseString(char[] s) {
    rec(s, 0);
  }

  private void rec(char[] s, int i) {
    if (i == s.length / 2) {
      return;
    }

    char temp = s[i];
    s[i] = s[s.length - i - 1];
    s[s.length - i - 1] = temp;
    rec(s, i + 1);
  }
}
