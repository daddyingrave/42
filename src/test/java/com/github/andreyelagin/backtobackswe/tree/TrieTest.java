package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

  @Test
  void search() {
    var trie = new Trie();
    trie.insert("hello");
    trie.insert("hell");
    trie.insert("halloween");
    
    assertTrue(trie.search("hello"));
    assertTrue(trie.search("hell"));
    assertTrue(trie.search("halloween"));
    
    assertFalse(trie.search("hel"));
  }

  @Test
  void startsWith() {
    var trie = new Trie();
    trie.insert("hello");
    trie.insert("hell");
    trie.insert("halloween");

    assertTrue(trie.startsWith("h"));
    assertTrue(trie.startsWith("hel"));
    assertTrue(trie.startsWith("hallow"));

    assertFalse(trie.startsWith("visian"));
  }
}