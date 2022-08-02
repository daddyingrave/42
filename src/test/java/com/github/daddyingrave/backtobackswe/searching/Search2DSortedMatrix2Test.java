package com.github.daddyingrave.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2DSortedMatrix2Test {

  Search2DSortedMatrix2 search = new Search2DSortedMatrix2();

  @Test
  void search2() {
    assertTrue(
        search.search2(
            new int[][]{
                new int[]{0, 1, 2, 3},
                new int[]{4, 5, 6, 7},
                new int[]{8, 9, 10, 11},
            },
            3
        )
    );
  }
}