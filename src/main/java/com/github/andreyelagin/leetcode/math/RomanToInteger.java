package com.github.andreyelagin.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  private static final Map<Character, Integer> romans = new HashMap<>();
  
  static {
    romans.put('I', 1);
    romans.put('V', 5);
    romans.put('X', 10);
    romans.put('L', 50);
    romans.put('C', 100);
    romans.put('D', 500);
    romans.put('M', 1000);
  }

  public int romanToInt(String s) {
    int acc = romans.get(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char first = s.charAt(i - 1);
      char second = s.charAt(i);
      if (romans.get(first) - romans.get(second) < 0) {
        acc -= romans.get(first);
        acc += (romans.get(second) - romans.get(first));
      } else {
        acc += romans.get(second);
      }
    }

    return acc;
  }
}
