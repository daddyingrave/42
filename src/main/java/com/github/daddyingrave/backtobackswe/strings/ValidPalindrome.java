package com.github.daddyingrave.backtobackswe.strings;

public class ValidPalindrome {
  public boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left <= right) {
      while (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (!Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      
      if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
        return false;
      }
    }
    
    return true;
  }
}
