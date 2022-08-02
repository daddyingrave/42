package com.github.daddyingrave.leetcode.strings;

import java.util.ArrayList;

public class StringToInteger {
  public int myAtoi(String s) {
    s = s == null ? "" : s.trim();
    if (s.isEmpty()) {
      return 0;
    }
    if (!Character.isDigit(s.charAt(0))) {
      if (s.charAt(0) != '-' && s.charAt(0) != '+') {
        return 0;
      }
    }
    
    boolean negative;
    int initialIndex = 0;
    if (s.charAt(0) == '-') {
      negative = true;
      s = s.substring(1);
    } else if (s.charAt(0) == '+') {
      negative = false;
      s = s.substring(1);
    } else {
      negative = false;
    }
    
    if (s.isEmpty() || negative && !Character.isDigit(s.charAt(initialIndex))) {
      return 0;
    }

    var numbers = new ArrayList<Integer>();
    if (s.charAt(0) == '0') {
      while (s.length() > 0 && s.charAt(0) == '0') {
        s = s.substring(1);
      }
    }
    for (int i = initialIndex; i < s.length(); i++) {
      if (numbers.size() > 10) {
        if (negative) {
          return Integer.MIN_VALUE;
        } else {
          return Integer.MAX_VALUE;
        }
      }
      
      char symbol = s.charAt(i);
      if (!Character.isDigit(symbol)) {
        break;
      } else {
        numbers.add(s.charAt(i) - '0');
      }
    }
    
    int base = 1;
    long sum = 0;
    var sb = new StringBuilder();
    for (int i = 0; i < numbers.size(); i++) {
      sb.append(numbers.get(i));
    }
    
    if (sb.length() == 0) {
      return 0;
    }
    
    sum = Long.parseLong(sb.toString());
    
    if (negative) {
      if (-sum < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      } else {
        return (int) -sum;
      }
    } else {
      if (sum > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else {
        return (int) sum;
      }
    }
  }
}
