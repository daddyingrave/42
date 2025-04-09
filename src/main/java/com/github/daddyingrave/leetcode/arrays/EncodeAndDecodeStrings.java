package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
  final char separator = '#';

  public String encode(List<String> strs) {
    var sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length());
      sb.append(separator);
      sb.append(str);
    }

    return sb.toString();
  }

  public List<String> decode(String str) {
    if (str == null || str.isEmpty()) {
      return List.of();
    }

    var result = new ArrayList<String>();

    var buf = new StringBuilder();
    int ptr = 0;
    while (ptr < str.length()) {
      while (str.charAt(ptr) != separator) {
        buf.append(str.charAt(ptr++));
      }

      int wordLength = Integer.parseInt(buf.toString());
      buf.delete(0, buf.length());
      ptr++;

      while (wordLength > 0) {
        buf.append(str.charAt(ptr++));
        wordLength--;
      }

      result.add(buf.toString());
      buf.delete(0, buf.length());
    }

    return result;
  }
}
