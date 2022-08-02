package com.github.daddyingrave.leetcode.math;

public class ExcelSheetColumnNumber {
  public int titleToNumber(String columnTitle) {
    int titleNumber = 0;

    int length = columnTitle.length();
    int pow = 0;
    
    for (int i = length - 1; i >= 0; i--) {
      titleNumber += Math.pow(26, pow++) * (columnTitle.charAt(i) - '@');
    }
    
    return titleNumber;
  }
}
