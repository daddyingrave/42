package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyHashSetTest {

  @Test
  void add() {
    var set = new MyHashSet();
    set.add(1);      // set = [1]
    assertTrue(set.contains(1));// return True
    set.add(2);      // set = [1, 2]
    assertFalse(set.contains(3)); // return False, (not found)
    set.add(2);      // set = [1, 2]
    assertTrue(set.contains(2)); // return True
    set.add(4);
    assertTrue(set.contains(4));
    set.add(5);
    assertTrue(set.contains(5));
    set.add(6);
    assertTrue(set.contains(6));
    set.add(7);
    assertTrue(set.contains(7));
    set.add(8);
    assertTrue(set.contains(8));
    set.add(9);
    assertTrue(set.contains(9));
    set.remove(9);
    assertFalse(set.contains(9));
  }

  @Test
  void add2() {
    var set = new MyHashSet();
    set.add(1);
    assertTrue(set.contains(1));
    set.add(2);
    assertTrue(set.contains(2));
    set.add(3);
    assertTrue(set.contains(3));
    set.add(4);
    assertTrue(set.contains(4));
    set.add(5);
    assertTrue(set.contains(5));
    set.add(6);
    assertTrue(set.contains(6));
    set.add(7);
    assertTrue(set.contains(7));
    set.add(8);
    assertTrue(set.contains(8));
    set.add(9);
    assertTrue(set.contains(9));
    set.remove(9);
    assertFalse(set.contains(9));
    set.remove(8);
    assertFalse(set.contains(9));
  }
}
