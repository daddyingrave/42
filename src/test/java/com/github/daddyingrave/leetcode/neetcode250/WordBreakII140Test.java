package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class WordBreakII140Test {
  class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      var result = new ArrayList<String>();
      backtrack(0, s, new HashSet<>(wordDict), new ArrayList<>(), result);
      return result;
    }

    void backtrack(int i, String s, Set<String> dict, List<String> cur, List<String> result) {
      if (i == s.length()) {
        result.add(String.join(" ", cur));
        return;
      }

      for (int j = 0; j < s.length(); j++) {
        String w = s.substring(i, j + 1);
        if (dict.contains(w)) {
          cur.add(w);
          backtrack(j + 1, s, dict, cur, result);
          cur.remove(cur.size() - 1);
        }
      }
    }
  }

  @Test
  void test() {

  }
}
