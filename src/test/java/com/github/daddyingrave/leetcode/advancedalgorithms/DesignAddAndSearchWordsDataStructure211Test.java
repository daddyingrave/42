package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DesignAddAndSearchWordsDataStructure211Test {
  class WordDictionary {
    TrieNode root = new TrieNode();

    public WordDictionary() {
    }

    public void addWord(String word) {
      var curNode = root;
      for (int i = 0; i < word.length(); i++) {
        var nextNode = curNode.children.get(word.charAt(i));
        if (nextNode == null) {
          nextNode = new TrieNode();
          curNode.children.put(word.charAt(i), nextNode);
        }

        curNode = nextNode;
      }

      curNode.word = true;
    }

    public boolean search(String word) {
      return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode node) {
      if (node == null) return false;
      if (idx == word.length()) return node.word;

      char c = word.charAt(idx);
      if (c == '.') {
        for (TrieNode child : node.children.values()) {
          if (dfs(word, idx + 1, child)) return true;
        }
        return false;
      } else {
        TrieNode next = node.children.get(c);
        return dfs(word, idx + 1, next);
      }
    }

    static class TrieNode {
      boolean word;
      Map<Character, TrieNode> children = new HashMap<>();
    }
  }

  @Test
  void test() {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    assertFalse(wordDictionary.search("pad"));
    assertTrue(wordDictionary.search("bad"));
    assertTrue(wordDictionary.search(".ad"));
    assertTrue(wordDictionary.search("b.."));
  }

  @Test
  void test2() {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("a");
    wordDictionary.addWord("a");
    assertTrue(wordDictionary.search("."));
    assertTrue(wordDictionary.search("a"));
    assertFalse(wordDictionary.search("aa"));
    assertTrue(wordDictionary.search("a"));
    assertFalse(wordDictionary.search(".a"));
    assertFalse(wordDictionary.search("a."));
  }
}
