package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class WordLadder127Test {
  class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      var adj = new HashMap<String, List<String>>();
      for (String word : wordList) {
        for (int i = 0; i < word.length(); i++) {
          char[] charArray = word.toCharArray();
          charArray[i] = '*';
          String pattern = String.copyValueOf(charArray);
          adj.putIfAbsent(pattern, new ArrayList<>());
          adj.get(pattern).add(word);
        }
      }

      var visited = new HashSet<String>();
      var queue = new LinkedList<String>();
      queue.offer(beginWord);
      visited.add(beginWord);

      int depth = 1;
      while (!queue.isEmpty()) {
        int capturedSize = queue.size();
        while (capturedSize > 0) {
          String next = queue.poll();
          capturedSize--;
          visited.add(next);

          if (Objects.equals(next, endWord)) {
            return depth;
          }

          for (int i = 0; i < next.length(); i++) {
            char[] nextPattern = next.toCharArray();
            nextPattern[i] = '*';
            List<String> matches = adj.get(String.copyValueOf(nextPattern));
            if (matches != null) {
              for (String neighbor : matches) {
                if (!visited.contains(neighbor)) {
                  queue.offer(neighbor);
                }
              }
            }
          }
        }

        depth++;
      }

      return 0;
    }
  }

  @Test
  void test() {

  }
}
