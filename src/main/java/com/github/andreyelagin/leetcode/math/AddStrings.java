package com.github.andreyelagin.leetcode.math;

public class AddStrings {
  public String addStrings(String num1, String num2) {
    var result = new StringBuilder();
    
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int first = i < 0 ? 0 : num1.charAt(i) - '0';
      int second = j < 0 ? 0 : num2.charAt(j) - '0';
      int sum = first + second + carry;
      carry = sum > 9 ? 1 : 0;
      result.append(sum % 10);
      i--;
      j--;
    }
    if (carry > 0) {
      result.append(1);
    }

    return result.reverse().toString();
  }
}
