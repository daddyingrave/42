package com.github.daddyingrave.backtobackswe.hashtables;

public class LongestSubstringMostKCharacters {
  public int longestSubstringWithAtMostKDistinctCharacters(String s, int k) {
    var map = new int[128];
    int res = 0;
    int left = 0;
    int right = 0;
    int distinct = 0;

    while (right < s.length()) {
      if (map[s.charAt(right)] == 0) {
        distinct++;
      }
      map[s.charAt(right)]++;
      
      while (distinct > k) {
        map[s.charAt(left)]--;
        if (map[s.charAt(left)] == 0) {
          distinct--;
        }
        left++;
      }

      res = Math.max(right - left + 1, res);
      right++;
    }

    return res;
  }
}
