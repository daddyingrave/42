package com.github.daddyingrave.backtobackswe.strings;

public class ZigzagConversion {
  public String zigzag(String s, int rows) {
    StringBuilder[] sbs = new StringBuilder[rows];
    for (int i = 0; i < rows; i++) {
      sbs[i] = new StringBuilder();
    }

    int index = 0;
    boolean down = false;

    for (char c : s.toCharArray()) {
      sbs[index].append(c);
      if (index == rows - 1 || index == 0) {
        down = !down;
      }
      if (rows > 1) {
        if (down) {
          index++;
        } else {
          index--;
        }
      }
    }

    var commonSb = new StringBuilder();
    for (StringBuilder sb : sbs) {
      commonSb.append(sb.toString());
    }

    return commonSb.toString();
  }

  public String zigzagMy(String s, int rows) {
    StringBuilder[] sbs = new StringBuilder[rows];
    for (int i = 0; i < rows; i++) {
      sbs[i] = new StringBuilder();
    }
    int symbolIndex = 0;
    while (symbolIndex < s.length()) {
      for (int zig = 0; zig < rows && symbolIndex < s.length(); zig++) {
        var zigChar = s.charAt(symbolIndex++);
        sbs[zig].append(zigChar);
      }
      for (int zag = rows - 2; zag >= 1 && symbolIndex < s.length(); zag--) {
        var zagChar = s.charAt(symbolIndex++);
        sbs[zag].append(zagChar);
      }
    }

    var commonSb = new StringBuilder();
    for (StringBuilder sb : sbs) {
      commonSb.append(sb.toString());
    }

    return commonSb.toString();
  }
}
