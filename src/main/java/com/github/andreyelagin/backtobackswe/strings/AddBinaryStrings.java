package com.github.andreyelagin.backtobackswe.strings;

public class AddBinaryStrings {
  public String addBinaryStrings(String s1, String s2) {
    var sb = new StringBuilder();

    boolean reminder = false;
    int s1Length = s1.length() - 1;
    int s2Length = s2.length() - 1;
    while (s1Length >= 0 || s2Length >= 0) {
      int sum = 0;
      if (reminder) {
        sum += 1;
        reminder = false;
      }
      if (s1Length >= 0) {
        sum += (s1.charAt(s1Length--) - '0');
      }
      if (s2Length >= 0) {
        sum += (s2.charAt(s2Length--) - '0');
      }
      if (sum == 2) {
        reminder = true;
        sum = 0;
      }
      if (sum > 2) {
        reminder = true;
        sum = 1;
      }
      sb.append(sum);
    }

    if (reminder) {
      sb.append(1);
    }

    return sb.reverse().toString();
  }
}
