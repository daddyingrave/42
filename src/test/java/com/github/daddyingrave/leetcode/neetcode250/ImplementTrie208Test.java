package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ImplementTrie208Test {
  class Trie {
    Node root = new Node(false);

    public Trie() {
    }

    public void insert(String word) {
      var cur = root;
      for (int i = 0; i < word.length(); i++) {
        char curLetter = word.charAt(i);
        if (cur.children.containsKey(curLetter)) {
          cur = cur.children.get(curLetter);
        } else {
          var newNode = new Node(false);
          cur.children.put(curLetter, newNode);
          cur = newNode;
        }
      }

      cur.word = true;
    }

    public boolean search(String word) {
      var cur = root;
      for (int i = 0; i < word.length(); i++) {
        char curLetter = word.charAt(i);
        cur = cur.children.get(curLetter);
        if (cur == null) {
          return false;
        }
      }

      return cur.word;
    }

    public boolean startsWith(String prefix) {
      var cur = root;
      for (int i = 0; i < prefix.length(); i++) {
        char curLetter = prefix.charAt(i);
        cur = cur.children.get(curLetter);
        if (cur == null) {
          return false;
        }
      }

      return cur.word || !cur.children.isEmpty();
    }

    static class Node {
      Map<Character, Node> children = new HashMap<>();
      boolean word;

      public Node(boolean word) {
        this.word = word;
      }
    }
  }

  @Test
  void test() {
    Trie trie = new Trie();

    trie.insert("apple");
    assertTrue(trie.search("apple"));
    assertFalse(trie.search("app"));
    assertTrue(trie.startsWith("app"));

    trie.insert("app");
    assertTrue(trie.search("app"));
  }
}
