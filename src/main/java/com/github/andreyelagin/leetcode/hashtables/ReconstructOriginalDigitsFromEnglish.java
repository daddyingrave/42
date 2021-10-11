package com.github.andreyelagin.leetcode.hashtables;

import java.util.HashMap;

public class ReconstructOriginalDigitsFromEnglish {
  public String originalDigits(String s) {
    var charsCount = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      var letter = s.charAt(i);
      charsCount.put(letter, charsCount.getOrDefault(letter, 0) + 1);
    }

    int[] result = new int[10];
    result[0] = charsCount.getOrDefault('z', 0);
    result[2] = charsCount.getOrDefault('w', 0);
    result[4] = charsCount.getOrDefault('u', 0);
    result[6] = charsCount.getOrDefault('x', 0);
    result[8] = charsCount.getOrDefault('g', 0);
    result[3] = charsCount.getOrDefault('h', 0) - result[8];
    result[5] = charsCount.getOrDefault('f', 0) - result[4];
    result[7] = charsCount.getOrDefault('s', 0) - result[6];
    result[9] = charsCount.getOrDefault('i', 0) - result[5] - result[6] - result[8];
    result[1] = charsCount.getOrDefault('n', 0) - result[7] - 2 * result[9];

    var sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      if (result[i] > 0) {
        sb.append(Integer.toString(i).repeat(result[i]));
      }
    }

    return sb.toString();
  }
}
