package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class WordSearchII212Test {
  public List<String> findWords(char[][] board, String[] words) {
    var result = new HashSet<String>();
    var trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    char[][] visited = new char[board.length][board[0].length];

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        dfs(board, row, col, trie, new StringBuilder(), result, visited);
      }
    }

    return new ArrayList<>(result);
  }

  void dfs(char[][] board, int row, int col, Trie trie, StringBuilder sb, Set<String> result, char[][] visited) {
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

    sb.append(board[row][col]);
    visited[row][col] = '*';

    if (!trie.startsWith(sb.toString())) {
      sb.deleteCharAt(sb.length() - 1);
      visited[row][col] = '0';
      return;
    }

    if (trie.search(sb.toString())) {
      result.add(sb.toString());
    }

    dfs(board, row + 1, col, trie, sb, result, visited);
    dfs(board, row - 1, col, trie, sb, result, visited);
    dfs(board, row, col + 1, trie, sb, result, visited);
    dfs(board, row, col - 1, trie, sb, result, visited);

    visited[row][col] = '0';
    sb.deleteCharAt(sb.length() - 1);
  }

  class Trie {
    TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
      var curNode = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        var nextNode = curNode.children.get(c);
        if (nextNode == null) {
          nextNode = new TrieNode();
          curNode.children.put(c, nextNode);
        }

        curNode = nextNode;
      }

      curNode.word = true;
    }

    public boolean search(String word) {
      var curNode = root;
      for (int i = 0; i < word.length(); i++) {
        var nextNode = curNode.children.get(word.charAt(i));
        if (nextNode == null) {
          return false;
        }

        curNode = nextNode;
      }

      return curNode.word;
    }

    public boolean startsWith(String prefix) {
      var curNode = root;
      for (int i = 0; i < prefix.length(); i++) {
        var nextNode = curNode.children.get(prefix.charAt(i));
        if (nextNode == null) {
          return false;
        }

        curNode = nextNode;
      }

      return true;
    }

    static class TrieNode {
      Map<Character, TrieNode> children = new HashMap<>();
      boolean word;
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
