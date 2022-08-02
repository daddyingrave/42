package com.github.daddyingrave.backtobackswe.heaps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LargestElementsInImmutableMaxHeapTest {

  LargestElementsInImmutableMaxHeap largest = new LargestElementsInImmutableMaxHeap();

  @Test
  void kLargestInImmutableHeap() {
    assertEquals(
        List.of(17, 16),
        largest.kLargestInImmutableHeap(new int[]{17, 7, 16, 2, 3, 15, 14}, 2)
    );
  }
}