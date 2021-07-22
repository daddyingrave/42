package com.github.andreyelagin.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest {

  @Test
  void next() {
    var vec = new Vector2D(new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{4}});
    assertEquals(1, vec.next());
    assertEquals(2, vec.next());
    assertEquals(3, vec.next());
    assertTrue(vec.hasNext());
    assertTrue(vec.hasNext());
    assertEquals(4, vec.next());
    assertFalse(vec.hasNext());
  }

  @Test
  void next2() {
    var vec = new Vector2D(new int[][]{new int[]{}, new int[]{3}, new int[]{}, new int[]{}, new int[]{}});
    assertTrue(vec.hasNext());
    assertEquals(3, vec.next());
    assertFalse(vec.hasNext());
  }
}