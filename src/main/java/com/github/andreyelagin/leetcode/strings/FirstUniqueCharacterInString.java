package com.github.andreyelagin.leetcode.strings;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacterInString {
  public int firstUniqChar(String s) {
    Queue<Pair<Character, Integer>> chars = new LinkedList<>();
    int[] charsCount = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (charsCount[curChar - 'a'] == 0) {
        chars.offer(new Pair<>(curChar, i));
      }
      charsCount[curChar - 'a']++;
    }
    
    while (!chars.isEmpty()) {
      var charToIndex = chars.poll();
      if (charsCount[charToIndex.getKey() - 'a'] == 1) {
        return charToIndex.getValue();
      }
    }
    
    return -1;
  }
}
