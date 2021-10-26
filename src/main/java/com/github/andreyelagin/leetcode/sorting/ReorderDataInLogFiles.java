package com.github.andreyelagin.leetcode.sorting;

import java.util.Arrays;
import java.util.Map;

public class ReorderDataInLogFiles {
  public String[] reorderLogFiles(String[] logs) {
    return Arrays.stream(logs)
        .map(s -> {
          int firstSpaceIndex = s.indexOf(' ');
          return Map.entry(s.substring(0, firstSpaceIndex), s.substring(firstSpaceIndex + 1));
        })
        .sorted((o1, o2) -> {
          boolean leftIsDigit = isDigit(o1.getValue());
          boolean rightIsDigit = isDigit(o2.getValue());
          if (leftIsDigit && rightIsDigit) {
            return 0;
          } else if (leftIsDigit) {
            return 1;
          } else if (rightIsDigit) {
            return -1;
          } else {
            var equality = o1.getValue().compareTo(o2.getValue());
            return equality == 0 ? o1.getKey().compareTo(o2.getKey()) : equality;
          }
        })
        .map(e -> e.getKey() + " " + e.getValue())
        .toArray(String[]::new);
  }

  private boolean isDigit(String log) {
    return Character.isDigit(log.charAt(0));
  }
}
