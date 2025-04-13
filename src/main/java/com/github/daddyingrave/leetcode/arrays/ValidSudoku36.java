package com.github.daddyingrave.leetcode.arrays;

import java.util.HashSet;

public class ValidSudoku36 {
  public boolean isValidSudoku(char[][] board) {
    var set = new HashSet<Character>();

    for (int row = 0; row < 9; row++) {
      for (int cal = 0; cal < 9; cal++) {
        if (board[row][cal] != '.') {
          if (!set.add(board[row][cal])) {
            return false;
          }
        }
      }
      set.clear();
    }

    for (int col = 0; col < 9; col++) {
      for (int row = 0; row < 9; row++) {
        if (board[row][col] != '.') {
          if (!set.add(board[row][col])) {
            return false;
          }
        }
      }
      set.clear();
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int row = i * 3;
        int col = j * 3;
        while (row < i * 3 + 3) {
          while (col < j * 3 + 3) {
            if (board[row][col] != '.') {
              if (!set.add(board[row][col])) {
                return false;
              }
            }
            col++;
          }
          row++;
          col = j * 3;
        }
        set.clear();
      }
    }

    return true;
  }
}
