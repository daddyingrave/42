package com.github.andreyelagin.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeOverlappingIntervalsTest {

  MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();

  @Test
  void mergeOverlappingIntervals() {
    assertArrayEquals(
        new int[][]{new int[]{1, 5}},
        mergeOverlappingIntervals.mergeOverlappingIntervals(
            new int[][]{new int[]{1, 5}, new int[]{1, 4}}
        )
    );
    assertArrayEquals(
        new int[][]{new int[]{1, 10}, new int[]{13, 15}},
        mergeOverlappingIntervals.mergeOverlappingIntervals(
            new int[][]{
                new int[]{1, 5},
                new int[]{2, 3},
                new int[]{4, 10},
                new int[]{13, 15},
            }
        )
    );
  }
}