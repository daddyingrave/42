package com.github.andreyelagin.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeMapTest {

  @Test
  void set() {
    var solution = new TimeMap();
    solution.set("foo", "bar", 1);
    assertEquals("bar", solution.get("foo", 1));
    assertEquals("bar", solution.get("foo", 3));
    solution.set("foo", "bar2", 4);
    assertEquals("bar2", solution.get("foo", 4));
    assertEquals("bar2", solution.get("foo", 5));
  }
}