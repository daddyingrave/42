package com.github.andreyelagin.backtobackswe.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EraseIntervalOverlapsTest {

  EraseIntervalOverlaps eraseIntervalOverlaps = new EraseIntervalOverlaps();
  
  @Test
  void eraseOverlapIntervals() {
    assertEquals(
        0,
        eraseIntervalOverlaps.eraseOverlapIntervals(
            new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
            }
        )
    );
    assertEquals(
        1,
        eraseIntervalOverlaps.eraseOverlapIntervals(
            new int[][]{
                new int[]{1, 2},
                new int[]{1, 2},
                new int[]{3, 4},
            }
        )
    );
  }
}