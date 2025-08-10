package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class WordSearchII212Test {
  public List<String> findWords(char[][] board, String[] words) {
    var result = new HashSet<String>();
    var trie = new TrieNode();
    for (String word : words) {
      trie.addWord(word);
    }

    char[][] visited = new char[board.length][board[0].length];

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        dfs(board, row, col, trie, "", result, visited);
      }
    }

    return new ArrayList<>(result);
  }

  void dfs(char[][] board, int row, int col, TrieNode node, String word, Set<String> result, char[][] visited) {
    int rows = board.length;
    int cols = board[0].length;

    if (row >= rows || col >= cols) {
      return;
    }
    if (row < 0 || col < 0) {
      return;
    }
    if (visited[row][col] == '*') {
      return;
    }
    if (node.children[board[row][col] - 'a'] == null) {
      return;
    }

    word += board[row][col];
    visited[row][col] = '*';
    node = node.children[board[row][col] - 'a'];
    if (node.word) {
      result.add(word);
      node.word = false;
    }

    dfs(board, row + 1, col, node, word, result, visited);
    dfs(board, row - 1, col, node, word, result, visited);
    dfs(board, row, col + 1, node, word, result, visited);
    dfs(board, row, col - 1, node, word, result, visited);

    visited[row][col] = '0';
  }

  static class TrieNode {
    TrieNode[] children;
    boolean word;

    TrieNode() {
      children = new TrieNode[26];
    }

    public void addWord(String word) {
      var cur = this;
      for (char c : word.toCharArray()) {
        var node = cur.children[c - 'a'];
        if (node == null) {
          node = new TrieNode();
        }
        cur.children[c - 'a'] = node;
        cur = node;
      }

      cur.word = true;
    }
  }

  @Test
  void test() {
    assertThat(
        findWords(
            new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
            },
            new String[]{"oath", "pea", "eat", "rain"}
        ),
        containsInAnyOrder("eat", "oath")
    );
    assertThat(
        findWords(
            new char[][]{
                {'a', 'b', 'c', 'e'},
                {'x', 'x', 'c', 'd'},
                {'x', 'x', 'b', 'a'}
            },
            new String[]{"abc", "abcd"}
        ),
        containsInAnyOrder("abc", "abcd")
    );
    assertThat(
        findWords(
            new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
            },
            new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}
        ),
        containsInAnyOrder("oath", "eat", "hklf", "hf")
    );
  }
}
