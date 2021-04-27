package com.github.andreyelagin.backtobackswe;

public class ChangingBase {
  public static String changeBase(String numAsString, int b1, int b2) {
    boolean negative = numAsString.startsWith("-");
    int maxPower = numAsString.length() - 1;
    int start = negative ? 1 : 0;

    int base10Num = 0;

    for (int i = start; i < numAsString.length(); i++) {
      char ch = numAsString.charAt(i);
      int num;

      if (Character.isDigit(ch)) {
        num = ch - '0';
      } else {
        num = ch - 'A' + 10;
      }

      int positionWeight = maxPower - i;
      base10Num += num * Math.pow(b1, positionWeight);
    }

    if (base10Num == 0) {
      return "0";
    } else {
      return (negative ? "-" : "") + toBase(base10Num, b2);
    }
  }

  private static String toBase(int num, int base) {
    if (num == 0) {
      return "";
    }
    
    int lsd = num % base;

    char curChar;
    if (lsd >= 10) {
      curChar = (char) (lsd + 'A' - 10);
    } else {
      curChar = (char) (lsd + '0');
    }

    int withoutLsd = num / base;
    String strNum = toBase(withoutLsd, base);

    return strNum + curChar;
  }
}
