package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LFUCache460Test {
  class LFUCache {
    Map<Integer, LinkedList> listMap = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> valMap = new HashMap<>();
    int lfuCount;
    int capacity;

    public LFUCache(int capacity) {
      this.capacity = capacity;
    }

    void counter(int key) {
      int count = countMap.get(key);
      countMap.put(key, count + 1);
      listMap.putIfAbsent(count, new LinkedList());
      listMap.get(count).pop(key);

      listMap.putIfAbsent(count + 1, new LinkedList());
      listMap.get(count + 1).insertRight(key);

      if (count == lfuCount && listMap.get(lfuCount).size() == 0) {
        lfuCount++;
      }
    }

    public int get(int key) {
      Integer value = valMap.get(key);
      if (value == null) {
        return -1;
      } else {
        counter(key);
        return value;
      }
    }

    public void put(int key, int value) {
      Integer curValue = valMap.get(key);
      if (curValue == null && valMap.size() == capacity) {
        int res = listMap.get(lfuCount).popLeft();
        valMap.remove(res);
        countMap.remove(res);
      }

      valMap.put(key, value);
      countMap.putIfAbsent(key, 0);
      counter(key);
      lfuCount = Math.min(lfuCount, countMap.get(key));
    }

    class LinkedList {
      Node right;
      Node left;
      Map<Integer, Node> nodes = new HashMap<>();

      LinkedList() {
        right = new Node(Integer.MIN_VALUE);
        left = new Node(Integer.MAX_VALUE);
        left.next = right;
        right.prev = left;
      }

      void pop(int key) {
        Node node = nodes.get(key);
        if (node != null) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
          nodes.remove(node.key);
        }
      }

      void insertRight(int key) {
        var node = new Node(key);
        var curRight = right.prev;
        curRight.next = node;
        node.prev = curRight;
        node.next = right;
        right.prev = node;
        nodes.put(key, node);
      }

      int popLeft() {
        int leftVal = left.next.key;
        pop(leftVal);
        return leftVal;
      }

      int size() {
        return nodes.size();
      }

      void update(int key, int value) {

      }

      class Node {
        int key;
        Node next;
        Node prev;

        public Node(int key) {
          this.key = key;
        }
      }
    }
  }

  @Test
  void test() {
    LFUCache lfu = new LFUCache(2);
    lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
    lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
    assertEquals(1, lfu.get(1));      // return 1
    // cache=[1,2], cnt(2)=1, cnt(1)=2
    lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
    // cache=[3,1], cnt(3)=1, cnt(1)=2
    assertEquals(-1, lfu.get(2));      // return -1 (not found)
    assertEquals(3, lfu.get(3));      // return 3
    // cache=[3,1], cnt(3)=2, cnt(1)=2
    lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
    // cache=[4,3], cnt(4)=1, cnt(3)=2
    assertEquals(-1, lfu.get(1));      // return -1 (not found)
    assertEquals(3, lfu.get(3));      // return 3
    // cache=[3,4], cnt(4)=1, cnt(3)=3
    assertEquals(4, lfu.get(4));      // return 4
    // cache=[4,3], cnt(4)=2, cnt(3)=3
  }
}
