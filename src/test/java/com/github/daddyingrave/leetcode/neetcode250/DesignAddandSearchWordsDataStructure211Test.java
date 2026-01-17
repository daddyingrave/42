package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DesignAddandSearchWordsDataStructure211Test {
  class WordDictionary {
    Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
      var cur = root;
      for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);
        var child = cur.children.get(letter);
        if (child == null) {
          child = new Node();
          cur.children.put(letter, child);
        }
        cur = child;
      }

      cur.word = true;
    }

    public boolean search(String word) {
      return search(root, word, 0);
    }

    private boolean search(Node startNode, String word, int i) {
      var cur = startNode;

      for (int j = i; j < word.length(); j++) {
        char letter = word.charAt(j);
        if (letter == '.') {
          for (var kv : cur.children.entrySet()) {
            if (search(kv.getValue(), word, j + 1)) {
              return true;
            }
          }

          return false;
        } else {
          Node child = cur.children.get(letter);
          if (child == null) {
            return false;
          }

          cur = child;
        }
      }

      return cur.word;
    }

    class Node {
      Map<Character, Node> children = new HashMap<>();
      boolean word;
    }
  }

  @Test
  void test() {
    var dict = new WordDictionary();
    dict.addWord("a");
    dict.addWord("bad");
    dict.addWord("dad");
    dict.addWord("mad");
    assertFalse(dict.search("pad"));
    assertTrue(dict.search("bad"));
    assertTrue(dict.search(".ad"));
    assertTrue(dict.search("b.."));
  }
}
