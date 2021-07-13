package com.github.andreyelagin.leetcode.strings;

public class ReverseInteger {
  public int reverse(int x) {
    var numStr = Integer.toString(x);
    int result = 0;
    
    int i;
    boolean negative = numStr.charAt(0) == '-';
    if (negative) {
      i = 1;
    } else {
      i = 0;
    }
    
    int multiple = 1;
    while (i < numStr.length()) {
      int cur = numStr.charAt(i) - '0';
      
      long temp = result + (long) cur * multiple;
      if (temp > Integer.MAX_VALUE) {
        return 0;
      }
      result = (int) temp;
      
      multiple *= 10;
      i++;
    }
    
    return negative ? -result : result;
  }
}
