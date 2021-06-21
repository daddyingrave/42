package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfDistinctIslandsTest {

  NumberOfDistinctIslands numberOfDistinctIslands = new NumberOfDistinctIslands();

  @Test
  void numberOfDistinctIslands() {
    assertEquals(
        3,
        numberOfDistinctIslands.numberOfDistinctIslands(
            new int[][]{
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 1},
                new int[]{1, 1, 0, 0, 1}
            }
        )
    );
  }
}
