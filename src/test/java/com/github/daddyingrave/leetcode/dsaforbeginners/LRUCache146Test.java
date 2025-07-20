package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LRUCache146Test {
  // LRUCache lRUCache = new LRUCache(2);
  // lRUCache.put(1, 1); // cache is {1=1}
  // lRUCache.put(2, 2); // cache is {1=1, 2=2}
  // lRUCache.get(1);    // return 1
  // lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
  // lRUCache.get(2);    // returns -1 (not found)
  // lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
  // lRUCache.get(1);    // return -1 (not found)
  // lRUCache.get(3);    // return 3
  // lRUCache.get(4);    // return 4
  class LRUCache {
    Map<Integer, Node> storage = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      this.head.prev = tail;
      this.tail.next = head;
    }

    public int get(int key) {
      Node node = storage.get(key);
      if (node != null) {
        removeNode(node);
        updateMostRecent(node);

        return node.val;
      } else {
        return -1;
      }
    }

    public void put(int key, int value) {
      Node node = storage.get(key);
      if (node == null) {
        if (this.capacity == storage.size()) {
          var leastRecent = tail.next;
          storage.remove(leastRecent.key);
          tail.next = leastRecent.next;
          leastRecent.next.prev = tail;
        }

        node = new Node(value, key);
        storage.put(key, node);
        updateMostRecent(node);
      } else {
        node.val = value;
        removeNode(node);
        updateMostRecent(node);
      }
    }

    void updateMostRecent(Node node) {
      var mostRecent = head.prev;
      mostRecent.next = node;
      node.prev = mostRecent;
      node.next = head;
      head.prev = node;
    }

    void removeNode(Node node) {
      var prev = node.prev;
      var next = node.next;
      prev.next = next;
      next.prev = prev;
    }

    class Node {
      int val;
      int key;
      Node next;
      Node prev;

      Node(int val, int key) {
        this.val = val;
        this.key = key;
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
    LRUCache lRUCache = new LRUCache(3);
    lRUCache.put(1, 1);
    lRUCache.put(2, 2);
    lRUCache.put(3, 3);
    lRUCache.put(4, 4);
    assertEquals(4, lRUCache.get(4));
    assertEquals(3, lRUCache.get(3));
    assertEquals(2, lRUCache.get(2));
    assertEquals(-1, lRUCache.get(1));
    lRUCache.put(5, 5);
    assertEquals(-1, lRUCache.get(1));
    assertEquals(2, lRUCache.get(2));
    assertEquals(3, lRUCache.get(3));
    assertEquals(-1, lRUCache.get(4));
    assertEquals(5, lRUCache.get(5));
  }
}
