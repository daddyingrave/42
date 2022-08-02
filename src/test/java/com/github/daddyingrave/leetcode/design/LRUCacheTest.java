package com.github.daddyingrave.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

  @Test
  void test1() {
    var cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));
    cache.put(3, 3);
    assertEquals(-1, cache.get(2));
    cache.put(4, 4);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(3));
    assertEquals(4, cache.get(4));
  }

  @Test
  void test2() {
    var cache = new LRUCache(1);
    cache.put(2, 1);
    assertEquals(1, cache.get(2));
    cache.put(3, 2);
    assertEquals(-1, cache.get(2));
    assertEquals(2, cache.get(3));
  }
  
  @Test
  void test3() {
    var cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(2));
    assertEquals(1, cache.get(4));
  }

  @Test
  void test4() {
    var cache = new LRUCache(2);
    cache.put(2, 1);
    cache.put(3, 2);
    assertEquals(2, cache.get(3));
    assertEquals(1, cache.get(2));
    cache.put(4, 3);
    assertEquals(1, cache.get(2));
    assertEquals(-1, cache.get(3));
    assertEquals(3, cache.get(4));
  }

  @Test
  void test5() {
    var cache = new LRUCache(10);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    cache.put(6, 6);
    cache.put(7, 7);
    cache.put(8, 8);
    cache.put(9, 9);
    cache.put(10, 10);

    cache.get(1);
    cache.get(2);
    cache.get(3);
    cache.get(4);
    cache.get(5);

    
    cache.put(11, 11);
    assertEquals(-1, cache.get(6));
  }
}