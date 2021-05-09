package com.github.andreyelagin.backtobackswe.strings;

import java.util.*;

public class LongestPalindromeConstruction {
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      counts.compute(curChar, (k, v) -> v == null ? 1 : ++v);
    }
    
    PriorityQueue<Integer> numbers = new PriorityQueue<>(Comparator.reverseOrder());
    boolean flag = false;
    int result = 0;

    numbers.addAll(counts.values());

    for (Integer num : numbers) {
      if (num % 2 != 0) {
        if (!flag) {
          result += num;
          flag = true;
        } else {
          result += (num - 1);
        }
      } else {
        result += num;
      }
    }
      
    return result;
  }
}
