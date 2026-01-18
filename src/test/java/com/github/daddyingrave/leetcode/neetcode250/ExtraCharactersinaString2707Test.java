package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ExtraCharactersinaString2707Test {
  class Solution {
    public int minExtraChar(String s, String[] dictionary) {
      var root = new Node();
      for (String word : dictionary) {
        var cur = root;
        for (int j = 0; j < word.length(); j++) {
          char letter = word.charAt(j);
          Node child = cur.children.get(letter);
          if (child == null) {
            child = new Node();
            cur.children.put(letter, child);
          }

          cur = child;
        }

        cur.word = true;
      }

      HashMap<Integer, Integer> dp = new HashMap<>();
      dp.put(s.length(), 0);

      return dfs(0, dp, s, root);
    }

    int dfs(int i, Map<Integer, Integer> dp, String s, Node trie) {
      if (dp.containsKey(i)) {
        return dp.get(i);
      }

      int res = 1 + dfs(i + 1, dp, s, trie);
      var cur = trie;
      for (int j = i; j < s.length(); j++) {
        if (!cur.children.containsKey(s.charAt(j))) {
          break;
        }

        cur = cur.children.get(s.charAt(j));
        if (cur.word) {
          res = Math.min(res, dfs(j + 1, dp, s, trie));
        }
      }

      dp.put(i, res);
      return res;
    }

    class Node {
      Map<Character, Node> children = new HashMap<>();
      boolean word;
    }
  }

  @Test
  void test() {
    //  "cehy"
    //  "diz"
    //  "ds"
    //  "e"
    //  "gu"
    //  "ksv"
    //  "kzbu"
    //  "lb"
    //  "nuq"
    //  "o"
    //  "ox"
    //  "r"
    //  "tskz"
    //  "txhe"
    //  "v"
    //  "wmo"
    assertEquals(7, new Solution().minExtraChar(
        "dwmodizxvvbosxxw",
        new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}
    ));
  }
}
