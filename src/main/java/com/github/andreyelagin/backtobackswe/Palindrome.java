package com.github.andreyelagin.backtobackswe;

public class Palindrome {

  // 1. Find number of digits in number
  // 2. Base on number of digits calculate mask
  // 3. Find left by division on mask
  // 4. Find right by mod 10
  // 5. Compare, if true continue, if false return false
  // 6. number mod mask -> delete by 10
  // 7. Divide mask by 100
  // https://backtobackswe.com/platform/content/check-if-a-number-is-a-palindrome/video
  public static boolean isPalindrome(int x) {
    if (x < 0) return false;

    int log = (int) Math.log10(x);
    int digits = (int) (Math.floor(log) + 1);
    int mask = (int) (Math.pow(10, digits - 1));

    for (int i = 0; i < digits / 2; i++) {
      int left = x / mask;
      int right = x % 10;

      if (left != right) return false;

      x = (x % mask) / 10;
      mask /= 100;
    }

    return true;
  }
}

  
