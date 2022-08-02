package com.github.daddyingrave.backtobackswe.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

  @Test
  void get() {
    var lru = new LRUCache(3);
    lru.put(1, 1);
    lru.put(2, 2);
    lru.put(3, 3);
    
    assertEquals(1, lru.get(1));
    assertEquals(2, lru.get(2));
    assertEquals(3, lru.get(3));
    
    lru.put(4, 4);
    
    assertNull(lru.get(1));
    
    assertEquals(2, lru.get(2));
    
    lru.put(5, 5);
    
    assertNull(lru.get(3));
    assertEquals(2, lru.get(2));
  }
}