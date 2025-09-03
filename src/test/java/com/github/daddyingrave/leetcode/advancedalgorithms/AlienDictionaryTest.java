package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDictionaryTest {
  class Solution {
    public String foreignDictionary(String[] words) {
      var adjacency = new HashMap<Character, Set<Character>>();

      for (String word : words) {
        for (char c : word.toCharArray()) {
          adjacency.putIfAbsent(c, new HashSet<>());
        }
      }

      for (int i = 1; i < words.length; i++) {
        var left = words[i - 1];
        var right = words[i];
        int j = 0;
        boolean updated = false;
        while (j < Math.min(left.length(), right.length())) {
          if (left.charAt(j) != right.charAt(j)) {
            adjacency.get(left.charAt(j)).add(right.charAt(j));
            updated = true;
            break;
          }
          j++;
        }

        if (!updated && left.length() > right.length()) {
          return "";
        }
      }

      var result = new ArrayList<Character>();
      var visited = new HashSet<Character>();
      for (Character ch : adjacency.keySet()) {
        if (!dfs(ch, result, new HashSet<>(), visited, adjacency)) {
          return "";
        }
      }

      Collections.reverse(result);
      var sb = new StringBuilder();
      for (Character c : result) {
        sb.append(c);
      }

      return sb.toString();
    }

    boolean dfs(Character node, List<Character> result, Set<Character> path, Set<Character> visited, Map<Character, Set<Character>> adj) {
      if (path.contains(node)) {
        return false;
      }
      if (visited.contains(node)) {
        return true;
      }

      path.add(node);
      visited.add(node);

      for (Character next : adj.get(node)) {
        if (!dfs(next, result, path, visited, adj)) {
          return false;
        }
      }

      path.remove(node);
      result.add(node);

      return true;
    }
  }

  @Test
  void test() {
    new Solution().foreignDictionary(new String[]{"hrn", "hrf", "er", "enn", "rfnn"});
  }
}
