package com.github.andreyelagin.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidSudokuTest {

  ValidSudoku sudoku = new ValidSudoku();

  @Test
  void validSudoku() {
    int[][] field = new int[][]{
        new int[]{5, 3, 0, 0, 7, 0, 0, 0, 0},
        new int[]{6, 0, 0, 1, 9, 5, 0, 0, 0},
        new int[]{0, 9, 8, 0, 0, 0, 0, 6, 0},
        new int[]{8, 0, 0, 0, 6, 0, 0, 0, 3},
        new int[]{4, 0, 0, 8, 0, 3, 0, 0, 1},
        new int[]{7, 0, 0, 0, 2, 0, 0, 0, 6},
        new int[]{0, 6, 0, 0, 0, 0, 2, 8, 0},
        new int[]{0, 0, 0, 4, 1, 9, 0, 0, 5},
        new int[]{0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    assertTrue(sudoku.validSudoku(field));
  }
}