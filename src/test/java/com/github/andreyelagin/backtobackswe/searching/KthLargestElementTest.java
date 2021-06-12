package com.github.andreyelagin.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementTest {

  KthLargestElement kthLargestElement = new KthLargestElement();
  
  @Test
  void kthLargest() {
    assertEquals(1, kthLargestElement.kthLargest(new int[]{1, 2, 3, 4, 5, 6}, 6));
    assertEquals(6, kthLargestElement.kthLargest(new int[]{1, 2, 3, 4, 5, 6}, 1));
  }
}