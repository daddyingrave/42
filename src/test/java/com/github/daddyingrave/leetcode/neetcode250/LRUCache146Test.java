package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LRUCache146Test {
  class LRUCache {
    Map<Integer, Node> storage = new HashMap<>();
    Node recent;
    Node leastRecent;
    int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      recent = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
      leastRecent = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
      leastRecent.next = recent;
      recent.prev = leastRecent;
    }

    public int get(int key) {
      var node = storage.get(key);

      if (node != null) {
        liftNode(node);
        return node.val;
      }

      return -1;
    }

    public void put(int key, int value) {
      Node node = storage.get(key);
      if (node != null) {
        node.val = value;
        liftNode(node);
      } else {
        if (storage.size() == capacity) {
          var curLeastRecent = leastRecent.next;
          leastRecent.next = curLeastRecent.next;
          curLeastRecent.next.prev = leastRecent;
          storage.remove(curLeastRecent.key);
        }

        node = new Node(key, value);
        storage.put(key, node);

        var curRecent = recent.prev;
        curRecent.next = node;
        node.prev = curRecent;
        node.next = recent;
        recent.prev = node;
      }
    }

    void liftNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;

      var curRecent = recent.prev;
      curRecent.next = node;
      node.next = recent;
      node.prev = curRecent;
      recent.prev = node;
    }

    class Node {
      int key;
      int val;
      Node next;
      Node prev;

      @Override
      public String toString() {
        return "Node{" +
            "key=" + key +
            ", val=" + val +
            '}';
      }

      public Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }
  }

  @Test
  void test() {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    assertEquals(1, lRUCache.get(1));    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    assertEquals(-1, lRUCache.get(2));    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    assertEquals(-1, lRUCache.get(1));    // return -1 (not found)
    assertEquals(3, lRUCache.get(3));    // return 3
    assertEquals(4, lRUCache.get(4));    // return 4
  }

  @Test
  void test2() {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 0);
    lRUCache.put(2, 2);
    assertEquals(0, lRUCache.get(1));
    lRUCache.put(3, 3); // 4, 3
    assertEquals(-1, lRUCache.get(2));
    lRUCache.put(4, 4);
    assertEquals(-1, lRUCache.get(1));
    assertEquals(3, lRUCache.get(3));
    assertEquals(4, lRUCache.get(4));
  }

  @Test
  void test3() {
    LRUCache lRUCache = new LRUCache(2);
    assertEquals(-1, lRUCache.get(2));
    lRUCache.put(2, 6);
    assertEquals(-1, lRUCache.get(1));
    lRUCache.put(1, 5);
    lRUCache.put(1, 2);
    assertEquals(2, lRUCache.get(1));
    assertEquals(6, lRUCache.get(2));
  }
}
