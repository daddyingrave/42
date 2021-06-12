package com.github.andreyelagin.backtobackswe.hashtables;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final int limit;
  private final Map<Integer, Entry> cache = new HashMap<>();
  private final Entry first; 
  private final Entry last;

  public LRUCache(int limit) {
    this.limit = limit;
    first = new Entry(0, 0);
    last = new Entry(0, 0);
    first.next = last;
    last.prev = first;
  }

  public Integer get(int key) {
    var entry = cache.get(key);
    if (entry != null) {
      updateCache(entry);
      return entry.val;
    } else {
      return null;
    }
  }

  public void put(int key, int value) {
    var oldEntry = cache.get(key);
    if (oldEntry == null) {
      var newEntry = new Entry(value, key);
      insertCache(newEntry);
      cache.put(key, newEntry);
    } else {
      oldEntry.val = value;
      updateCache(oldEntry);
    }
    
    if (cache.size() > limit) {
      cleanUp();
    }
  }

  private void insertCache(Entry entry) {
    var prev = first.next;
    first.next = entry;
    entry.prev = first;
    entry.next = prev;
    prev.prev = entry;
  }

  private void updateCache(Entry entry) {
    if (cache.size() > 1) {
      var oldPrev = entry.prev;
      var oldNext = entry.next;
      oldPrev.next = oldNext;
      oldNext.prev = oldPrev;
      insertCache(entry);
    }
  }

  private void cleanUp() {
    var latest = last.prev;
    var lastPrev = last.prev.prev;
    lastPrev.next = last;
    cache.remove(latest.key);
  }

  private static class Entry {
    public int val;
    public int key;
    public Entry next;
    public Entry prev;

    public Entry(int val, int key) {
      this.val = val;
      this.key = key;
    }
  }
}
