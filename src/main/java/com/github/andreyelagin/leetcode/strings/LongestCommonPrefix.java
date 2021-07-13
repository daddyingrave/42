package com.github.andreyelagin.leetcode.strings;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    var sb = new StringBuilder();

    for (int i = 0; i < strs[0].length(); i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() < i + 1 || strs[j].charAt(i) != ch) {
          return sb.toString();
        }
      }
      sb.append(ch);
    }
    
    return sb.toString();
  }
}
