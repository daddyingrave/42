package com.github.andreyelagin.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

  TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

  @Test
  void topKFrequent() {
    assertArrayEquals(
        new int[]{1, 2},
        topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)
    );
  }
}