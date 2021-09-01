package com.github.andreyelagin.ctci.arraysandstrings;

import java.util.HashMap;

public class StringCompression {
  public String compress(String source) {
    var lettersCount = new HashMap<Character, Integer>();
    var sb = new StringBuilder();

    char prev = source.charAt(0);
    int prevCount = 1;
    for (int i = 1; i < source.length(); i++) {
      char ch = source.charAt(i);
      if (ch != prev) {
        sb.append(prev).append(prevCount);
        prev = ch;
        prevCount = 1;
      } else {
        prevCount++;
      }
    }

    sb.append(prev).append(prevCount);

    if (sb.length() >= source.length()) {
      return source;
    } else {
      return sb.toString();
    }
  }
}
