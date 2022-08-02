package com.github.daddyingrave.leetcode.strings;

import java.util.Stack;

public class DecodeString {
  public String decodeString(String s) {
    var nums = new Stack<Integer>();
    var strings = new Stack<StringBuilder>();
    var currentString = new StringBuilder();
    int k = 0;
    for (int i = 0; i < s.length(); i++) {
      char term = s.charAt(i);
      if (Character.isDigit(term)) {
        k = k * 10 + term - '0';
      } else if (term == '[') {
        nums.push(k);
        k = 0;
        strings.push(currentString);
        currentString = new StringBuilder();;
      } else if (term == ']') {
        int iterations = nums.pop();
        var word = strings.pop();
        while (iterations > 0) {
          word.append(currentString);
          iterations--;
        }
        currentString = word;
      } else {
        currentString.append(term);
      }
    }
    
    return currentString.toString();
  }
}
