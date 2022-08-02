package com.github.daddyingrave.backtobackswe.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

  @Test
  void insert() {
    var heap = new MaxHeap(10);

    heap.insert(100);
    heap.insert(140);
    heap.insert(40);

    assertEquals(140, heap.peek());
    assertFalse(heap.empty());

    assertEquals(140, heap.remove());
    assertEquals(100, heap.peek());
    assertFalse(heap.empty());

    assertEquals(100, heap.remove());
    assertEquals(40, heap.remove());
    assertTrue(heap.empty());
  }
}