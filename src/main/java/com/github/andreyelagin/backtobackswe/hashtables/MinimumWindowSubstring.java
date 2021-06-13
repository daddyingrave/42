package com.github.andreyelagin.backtobackswe.hashtables;

import java.util.*;

public class MinimumWindowSubstring {
  public String minWindow(String searchString, String t) {
    var requiredSymbols = new HashMap<Character, Integer>();
    var window = new HashMap<Character, Integer>();

    for (char c : t.toCharArray()) {
      requiredSymbols.compute(c, (ch, count) -> count == null ? 1 : ++count);
    }

    var result = "";
    int left = 0;
    int right = 0;
    int symbolsInWindow = 0;
    int requiredSymbolsCount = requiredSymbols.size();

    while (right < searchString.length()) {
      var curRight = searchString.charAt(right);
      increase(window, curRight);

      if (requiredSymbols.containsKey(curRight)) {
        if (requiredSymbols.get(curRight).equals(window.get(curRight))) {
          symbolsInWindow++;
        }
      }

      while (symbolsInWindow == requiredSymbolsCount && left <= right) {
        var curLeft = searchString.charAt(left);
        var newLength = right - left + 1;

        if (result.isEmpty() || result.length() > newLength) {
          result = searchString.substring(left, right + 1);
        }

        decrease(window, curLeft);

        if (requiredSymbols.containsKey(curLeft)) {
          if (window.get(curLeft) < requiredSymbols.get(curLeft)) {
            symbolsInWindow--;
          }
        }
        left++;
      }
      right++;
    }

    return result;
  }

  private void increase(Map<Character, Integer> matched, Character letter) {
    matched.compute(letter, (c, count) -> count == null ? 1 : ++count);
  }

  private void decrease(Map<Character, Integer> matched, Character letter) {
    matched.compute(letter, (c, count) -> count == null ? 1 : --count);
  }
}
