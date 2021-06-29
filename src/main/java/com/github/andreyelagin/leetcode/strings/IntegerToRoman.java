package com.github.andreyelagin.leetcode.strings;

public class IntegerToRoman {
  private static final int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static final String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String intToRoman(int num) {
    var sb = new StringBuilder();

    for (int i = 0; i < nums.length && num > 0; i++) {
      while (nums[i] <= num) {
        num -= nums[i];
        sb.append(roman[i]);
      }
    }

    return sb.toString();
  }
}
