package com.github.daddyingrave.backtobackswe.strings;

public class AddBinaryStrings {
  public String addBinaryStrings(String s1, String s2) {
    var sb = new StringBuilder();

    int carry = 0;
    int l = s1.length() - 1;
    int r = s2.length() - 1;
    while (l >= 0 || r >= 0) {
      int sum = carry;
      
      if (l >= 0) {
        sum += (s1.charAt(l--) - '0');
      }
      if (r >= 0) {
        sum += (s2.charAt(r--) - '0');
      }
      
      carry = sum / 2;
      sb.append(sum % 2);
    }

    if (carry != 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }
}
