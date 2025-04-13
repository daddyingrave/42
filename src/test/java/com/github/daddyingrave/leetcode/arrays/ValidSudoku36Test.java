package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidSudoku36Test {

  @Test
  void isValidSudoku() {
    var problem = new ValidSudoku36();
    assertTrue(problem.isValidSudoku(new char[][]{
        new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    }));

    assertFalse(problem.isValidSudoku(new char[][]{
        new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    }));

    assertFalse(problem.isValidSudoku(new char[][]{
        new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
        new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
        new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
        new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
        new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
        new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'},
    }));
  }
}
