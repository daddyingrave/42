package com.github.andreyelagin.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveSortingTest {

  @Test
  void bubble() {
    var unsorted = new int[]{5, 4, 3, 2, 1};
    var sorted = new int[]{1, 2, 3, 4, 5};
    PrimitiveSorting.bubble(unsorted);
    assertArrayEquals(sorted, unsorted);
  }

  @Test
  void insertion() {
    var unsorted = new int[]{5, 4, 3, 2, 1};
    var sorted = new int[]{1, 2, 3, 4, 5};
    PrimitiveSorting.insertion(unsorted);
    assertArrayEquals(sorted, unsorted);
  }

  @Test
  void selection() {
  }
}