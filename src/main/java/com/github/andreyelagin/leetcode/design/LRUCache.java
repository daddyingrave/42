package com.github.andreyelagin.leetcode.design;

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
    if (storage.containsKey(key)) {
      var node = storage.get(key);
      touch(node);
      return node.val;
    } else {
      return -1;
    }
  }

  private void touch(ListNodeLRU node) {
    if (storage.size() > 1) {
      var oldPrev = node.prev;
      var oldNext = node.next;
      oldPrev.next = oldNext;
      oldNext.prev = oldPrev;

      var prev = first.next;
      first.next = node;
      node.prev = first;
      node.next = prev;
      prev.prev = node;
    }
  }

  public void put(int key, int value) {
    if (storage.containsKey(key)) {
      var node = storage.get(key);
      node.val = value;
      touch(node);
      return;
    } else if (storage.size() == capacity) {
      var latest = last.prev;
      var lastPrev = last.prev.prev;
      lastPrev.next = last;
      storage.remove(latest.key);
    }
    
    var newNode = new ListNodeLRU(key, value);
    var prev = first.next;
    first.next = newNode;
    newNode.prev = first;
    newNode.next = prev;
    prev.prev = newNode;
    
    storage.put(key, newNode);
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
