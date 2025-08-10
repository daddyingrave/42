package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrefixAndSuffixSearch745Test {
  class WordFilter {
    Trie trie = new Trie();

    public WordFilter(String[] words) {
      for (int i = 0; i < words.length; i++) {
        var curWord = words[i];
        int wordLength = curWord.length();
        for (int j = 0; j < wordLength; j++) {
          var suffix = curWord.substring(j);
          for (int k = 0; k <= wordLength; k++) {
            var prefix = curWord.substring(0, k);
            trie.addWord(suffix + "{" + prefix, i);
          }
        }
      }
    }

    public int f(String pref, String suff) {
      return trie.search(suff + "{" + pref);
    }
  }

  class Trie {
    Trie[] children = new Trie[27];
    int index;

    void addWord(String word, int index) {
      var cur = this;

      for (char c : word.toCharArray()) {
        int i = c == '{' ? 26 : c - 'a';
        if (cur.children[i] == null) {
          cur.children[i] = new Trie();
        }
        cur = cur.children[i];
      }

      cur.index = index;
    }

    int search(String word) {
      var cur = this;

      for (char c : word.toCharArray()) {
        int i = c == '{' ? 26 : c - 'a';
        if (cur.children[i] == null) {
          return -1;
        }

        cur = cur.children[i];
      }

      return cur.index;
    }
  }

  @Test
  void test2() {
    WordFilter wordFilter = new WordFilter(new String[]{"apple"});
    assertEquals(0, wordFilter.f("a", "e"));
  }

  @Test
  void test3() {
    WordFilter wordFilter = new WordFilter(new String[]{"abbba", "abba"});
    assertEquals(1, wordFilter.f("ab", "ba"));
  }
}
