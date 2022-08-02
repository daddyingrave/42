package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import java.util.Arrays;

public class SudokuSolver {
  private static final char EMPTY_ENTRY = '.';

  public char[][] solveSudoku(char[][] board) {
    char[][] copy = Arrays.copyOf(board, board.length);
    solveFrom(0, 0, board);
    return copy;
  }
  
  private boolean solveFrom(int row, int col, char[][] board) {
    if (col == board[row].length) {
      row++;
      col = 0;
      if (row == board.length) {
        return true;
      }
    }
    
    if (board[row][col] != EMPTY_ENTRY) {
      return solveFrom(row, col + 1, board);
    }

    for (int i = 1; i <= 9; i++) {
      char toPlace = (char) (i + '0');
      
      if (canPlaceValue(row, col, toPlace, board)) {
        board[row][col] = toPlace;

        if (solveFrom(row, col + 1, board)) {
          return true;
        }
        
        board[row][col] = EMPTY_ENTRY;
      }
    }
    
    return false;
  }

  private boolean canPlaceValue(int row, int col, char value, char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == value) {
        return false;
      }
      if (board[i][col] == value) {
        return false;
      }
    }
    
    int topLeftRow = row / 3 * 3;
    int topLeftCol = col / 3 * 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (value == board[topLeftRow + i][topLeftCol + j]) {
          return false;
        }
      }
    }
    
    return true;
  }
}
