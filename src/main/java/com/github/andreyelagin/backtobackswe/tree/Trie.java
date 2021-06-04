package com.github.andreyelagin.backtobackswe.tree;

public class Trie {

  private final TrieNode root = new TrieNode('0');

  public void insert(String word) {
    var cur = root;
    for (int i = 0; i < word.length(); i++) {
      var letter = word.charAt(i);
      var index = letter - 'a';
      if (cur.children[index] == null) {
        cur.children[index] = new TrieNode(letter);
      }
      cur = cur.children[index];
    }
    cur.word = true;
  }

  public boolean search(String word) {
    TrieNode cur = getNode(word);
    if (cur == null) return false;
    return cur.word;
  }

  public boolean startsWith(String prefix) {
    return getNode(prefix) != null;
  }

  private TrieNode getNode(String word) {
    var cur = root;
    for (int i = 0; i < word.length(); i++) {
      var letter = word.charAt(i);
      var index = letter - 'a';
      if (cur.children[index] == null) {
        return null;
      }
      cur = cur.children[index];
    }
    return cur;
  }

  private static class TrieNode {
    public char character;
    public TrieNode[] children;
    public boolean word;

    public TrieNode(char character) {
      this.character = character;
      this.children = new TrieNode[26];
      this.word = false;
    }
  }
}
