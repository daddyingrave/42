package com.github.daddyingrave.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveSortingTest {

  @Test
  void bubble() {
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5},
        PrimitiveSorting.bubble(new int[]{5, 4, 3, 2, 1})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 5, 9},
        PrimitiveSorting.bubble(new int[]{9, 5, 3, 1, 2})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9},
        PrimitiveSorting.bubble(new int[]{9, 7, 8, 1, 3, 4, 5, 2, 6, 7})
    );
    assertArrayEquals(
        new int[]{-75, 0, 10, 100, 1000},
        PrimitiveSorting.bubble(new int[]{1000, 10, 100, -75, 0})
    );
  }

  @Test
  void insertion() {
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5},
        PrimitiveSorting.insertion(new int[]{5, 4, 3, 2, 1})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 5, 9},
        PrimitiveSorting.insertion(new int[]{9, 5, 3, 1, 2})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9},
        PrimitiveSorting.insertion(new int[]{9, 7, 8, 1, 3, 4, 5, 2, 6, 7})
    );
    assertArrayEquals(
        new int[]{-75, 0, 10, 100, 1000},
        PrimitiveSorting.insertion(new int[]{1000, 10, 100, -75, 0})
    );
  }

  @Test
  void selection() {
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5},
        PrimitiveSorting.selection(new int[]{5, 4, 3, 2, 1})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 5, 9},
        PrimitiveSorting.selection(new int[]{9, 5, 3, 1, 2})
    );
    assertArrayEquals(
        new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9},
        PrimitiveSorting.selection(new int[]{9, 7, 8, 1, 3, 4, 5, 2, 6, 7})
    );
    assertArrayEquals(
        new int[]{-75, 0, 10, 100, 1000},
        PrimitiveSorting.selection(new int[]{1000, 10, 100, -75, 0})
    );
  }
}