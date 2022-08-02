package com.github.daddyingrave.backtobackswe.heaps;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KSmallestElementsInArrayTest {

  KSmallestElementsInArray smallestElementsInArray = new KSmallestElementsInArray();

  @Test
  void kSmallestElements() {
    assertEquals(
        List.of(-2, 1),
        smallestElementsInArray.kSmallestElements(new int[]{3, 1, -2, 5, 7}, 2)
    );
  }
}