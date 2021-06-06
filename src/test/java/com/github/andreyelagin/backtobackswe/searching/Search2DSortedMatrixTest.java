package com.github.andreyelagin.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2DSortedMatrixTest {

  Search2DSortedMatrix search = new Search2DSortedMatrix();

  @Test
  void search() {
    assertTrue(
        search.search(
            new int[][]{
                new int[]{1, 4, 7, 11},
                new int[]{8, 9, 10, 20},
                new int[]{11, 12, 17, 30}
            },
            20
        )
    );
    assertFalse(
        search.search(
            new int[][]{
                new int[]{1, 4, 7, 11},
                new int[]{8, 9, 10, 20},
                new int[]{11, 12, 17, 30}
            },
            666
        )
    );
    assertFalse(search.search(new int[][] {}, 666));
  }
}