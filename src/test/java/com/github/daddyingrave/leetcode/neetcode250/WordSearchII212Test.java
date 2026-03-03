package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

public class WordSearchII212Test {
  class Solution {
    public List<String> findWords(char[][] board, String[] words) {
      var root = new TrieNode();
      for (String word : words) {
        var cur = root;
        for (int i = 0; i < word.length(); i++) {
          var letter = word.charAt(i);
          var child = cur.children.get(letter);
          if (child == null) {
            child = new TrieNode();
            cur.children.put(letter, child);
          }
          cur = child;
        }
        cur.word = true;
      }

      var visited = new char[board.length][board[0].length];
      var result = new ArrayList<String>();

      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          backtrack(i, j, board, root, visited, "", result);
        }
      }

      return result;
    }

    int[][] directions = new int[][]{
        {0, 1}, // col
        {1, 0}, // bottom
        {0, -1}, // row
        {-1, 0}, // up
    };

    void backtrack(
        int row,
        int col,
        char[][] board,
        TrieNode trie,
        char[][] visited,
        String cur,
        List<String> result
    ) {
      if (row < 0 || col < 0 || row >= board.length || col >= board[row].length
          || visited[row][col] == '*'
          || !trie.children.containsKey(board[row][col])
      ) {
        return;
      }

      visited[row][col] = '*';
      trie = trie.children.get(board[row][col]);
      cur += board[row][col];
      if (trie.word) {
        result.add(cur);
        trie.word = false;
      }

      for (int[] direction : directions) {
        backtrack(row + direction[0], col + direction[1], board, trie, visited, cur, result);
      }

      visited[row][col] = 0;
    }

    class TrieNode {
      Map<Character, TrieNode> children = new HashMap<>();
      boolean word;
    }
  }

  @Test
  void test() {
    assertThat(new Solution().findWords(
        new char[][]{
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        },
        new String[]{"oath", "pea", "eat", "rain"}
    ), containsInAnyOrder("eat", "oath"));
  }
}
