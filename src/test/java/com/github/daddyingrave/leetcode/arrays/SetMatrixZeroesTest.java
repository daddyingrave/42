package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroesTest {

  SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

  @Test
  void setZeroes() {
    var matrix = new int[][]{
        new int[]{1, 1, 1},
        new int[]{1, 0, 1},
        new int[]{1, 1, 1},
    };
    var matrixExpected = new int[][]{
        new int[]{1, 0, 1},
        new int[]{0, 0, 0},
        new int[]{1, 0, 1},
    };

    setMatrixZeroes.setZeroes(matrix);

    assertArrayEquals(matrixExpected, matrix);
  }

  @Test
  void setZeroes2() {
    var matrixExpected = new int[][]{
        new int[]{0, 0, 0, 0},
        new int[]{0, 4, 5, 0},
        new int[]{0, 3, 1, 0},
    };
    var matrix = new int[][]{
        new int[]{0, 1, 2, 0},
        new int[]{3, 4, 5, 2},
        new int[]{1, 3, 1, 5},
    };

    setMatrixZeroes.setZeroes(matrix);

    assertArrayEquals(matrixExpected, matrix);
  }

  @Test
  void setZeroes3() {
    //[[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]
    // [[0,0,3,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
    var matrixExpected = new int[][]{
        new int[]{0, 0, 3, 0},
        new int[]{0, 0, 0, 0},
        new int[]{0, 0, 0, 0},
        new int[]{0, 0, 0, 0},
    };
    var matrix = new int[][]{
        new int[]{1, 2, 3, 4},
        new int[]{5, 0, 7, 8},
        new int[]{0, 10, 11, 12},
        new int[]{13, 14, 15, 0},
    };

    setMatrixZeroes.setZeroes(matrix);

    assertArrayEquals(matrixExpected, matrix);
  }
}