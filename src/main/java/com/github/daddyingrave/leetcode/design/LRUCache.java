package com.github.daddyingrave.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final int capacity;
  private final Map<Integer, ListNodeLRU> storage = new HashMap<>();
  private final ListNodeLRU first;
  private final ListNodeLRU last;

  public LRUCache(int capacity) {
    first = new ListNodeLRU(-1, -1);
    last = new ListNodeLRU(-1, -1);
    first.next = last;
    last.prev = first;
    this.capacity = capacity;
  }

  public int get(int key) {
    var node = storage.get(key);
    if (node != null) {
      remove(node);
      insert(node);
      return node.val;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    var node = storage.get(key);
    if (node != null) {
      node.val = value;
      remove(node);
      insert(node);
    } else {
      var newNode = new ListNodeLRU(key, value);
      insert(newNode);
      storage.put(key, newNode);
    }

    if (storage.size() > capacity) {
      storage.remove(first.next.key);
      remove(first.next);
    }
  }

  private void insert(ListNodeLRU newNode) {
    var recent = last;
    var prev = last.prev;
    recent.prev = newNode;
    newNode.next = recent;
    prev.next = newNode;
    newNode.prev = prev;
  }

  private void remove(ListNodeLRU node) {
    if (storage.size() > 0) {
      var prev = node.prev;
      var next = node.next;
      prev.next = next;
      next.prev = prev;
    }
  }

  private static class ListNodeLRU {
    public int key;
    public int val;
    public ListNodeLRU next;
    public ListNodeLRU prev;

    public ListNodeLRU(int key, int val) {
      this.val = val;
      this.key = key;
    }

    @Override
    public String toString() {
      return "ListNodeLRU{" +
          "key=" + key +
          ", val=" + val +
          '}';
    }
  }
}
