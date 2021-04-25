package com.github.andreyelagin.backtobackswe;

public class AddStrings {
  public static String addStrings(String s1, String s2) {
    int i = s1.length() - 1;
    int j = s2.length() - 1;
    StringBuilder acc = new StringBuilder();

    int reminder = 0;
    while (i >= 0 || j >= 0) {
      int sum = reminder;
      if (i < s1.length() && i >= 0) {
        sum += s1.charAt(i) - '0';
        i--;
      }
      if (j < s2.length() && j >= 0) {
        sum += s2.charAt(j) - '0';
        j--;
      }

      acc.append(sum % 10);

      if (sum > 9) reminder = 1;
      else reminder = 0;
    }

    if (reminder > 0) acc.append(1);

    return acc.reverse().toString();
  }
}
