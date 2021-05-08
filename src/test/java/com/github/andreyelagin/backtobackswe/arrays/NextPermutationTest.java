package com.github.andreyelagin.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

  NextPermutation nextPermutation = new NextPermutation();

  @Test
  void nextPermutation() {
    assertArrayEquals(new int[]{1, 3, 2}, nextPermutation.nextPermutation(new int[]{1, 2, 3}));
    assertArrayEquals(new int[]{2, 1, 5}, nextPermutation.nextPermutation(new int[]{1, 5, 2}));
    assertArrayEquals(new int[]{1, 2, 3}, nextPermutation.nextPermutation(new int[]{3, 2, 1}));
  }
}