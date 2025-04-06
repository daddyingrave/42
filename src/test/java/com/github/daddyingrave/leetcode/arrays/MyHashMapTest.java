package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

  @Test
  void put() {
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    assertEquals(1, myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
    assertEquals(-1, myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    assertEquals(1, myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    assertEquals(-1, myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
  }
}
