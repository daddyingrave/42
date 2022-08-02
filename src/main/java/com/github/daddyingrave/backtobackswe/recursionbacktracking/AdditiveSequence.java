package com.github.daddyingrave.backtobackswe.recursionbacktracking;

public class AdditiveSequence {
  public boolean isAdditiveNumber(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }

    for (int left = 1; left < s.length(); left++) {
      long leftAdditive = num(s.substring(0, left));
      if (leftAdditive == -1) {
        continue;
      }
      for (int right = left + 1; right < s.length(); right++) {
        long rightAdditive = num(s.substring(left, right));
        
        if (rightAdditive == -1) {
          continue;
        }
        
        if (backtrack(leftAdditive, rightAdditive, s.substring(right))) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean backtrack(long left, long right, String third) {
    if (third.isEmpty()) {
      return true;
    }

    for (int i = 1; i <= third.length(); i++) {
      var thirdPart = third.substring(0, i);
      long thirdAdditive = num(thirdPart);
      if (thirdAdditive == -1) {
        continue;
      }

      if (
          thirdAdditive - left == right
              && backtrack(right, thirdAdditive, third.substring(i))
      ) {
        return true;
      }
    }

    return false;
  }

  private long num(String num) {
    if (!num.equals("0") && num.startsWith("0")) {
      return -1;
    }

    if (num.isEmpty()) {
      return -1;
    }

    try {
      return Long.parseLong(num);
    } catch (Throwable e) {
      return -1;
    }
  }
}
