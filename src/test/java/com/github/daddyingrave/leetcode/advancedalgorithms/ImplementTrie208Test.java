package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementTrie208Test {
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
          nextNode.val = c;
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
      Character val;
      boolean word;
    }
  }

  @Test
  void test() {
    var trie = new Trie();
    trie.insert("vasian");
    assertTrue(trie.search("vasian"));
    assertFalse(trie.search("piotr"));
    assertTrue(trie.startsWith("vas"));
    assertFalse(trie.startsWith("pio"));

    trie.insert("piotr");
    assertTrue(trie.search("vasian"));
    assertTrue(trie.search("piotr"));
    assertTrue(trie.startsWith("vas"));
    assertTrue(trie.startsWith("pio"));
  }
}
