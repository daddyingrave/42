package com.github.andreyelagin.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2DMatrixIITest {

  Search2DMatrixII solution = new Search2DMatrixII();

  @Test
  void searchMatrix() {
    assertTrue(
        solution.searchMatrix(
            new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
            },
            5
        )
    );
    assertTrue(
        solution.searchMatrix(
            new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20},
                new int[]{21, 22, 23, 24, 25}
            },
            5
        )
    );
    assertTrue(
        solution.searchMatrix(
            new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
            },
            30
        )
    );
    assertFalse(
        solution.searchMatrix(
            new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
            },
            20
        )
    );
    assertTrue(
        solution.searchMatrix(
            new int[][]{
                new int[]{-5}
            },
            -5
        )
    );
    assertTrue(
        solution.searchMatrix(
            new int[][]{
                new int[]{3, 3, 8, 13, 13, 18},
                new int[]{4, 5, 11, 13, 18, 20},
                new int[]{9, 9, 14, 15, 23, 23},
                new int[]{13, 18, 22, 22, 25, 27},
                new int[]{18, 22, 23, 28, 30, 33},
                new int[]{21, 25, 28, 30, 35, 35},
                new int[]{24, 25, 33, 36, 37, 40}
            },
            21
        )
    );
  }
}

// 
//
//
//
//
//
//
//
//