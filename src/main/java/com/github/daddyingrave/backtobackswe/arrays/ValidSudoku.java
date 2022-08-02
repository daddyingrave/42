package com.github.daddyingrave.backtobackswe.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
  public boolean validSudoku(int[][] board) {
    Map<Integer, Set<Integer>> rows = new HashMap<>();
    Map<Integer, Set<Integer>> columns = new HashMap<>();
    Map<String, Set<Integer>> squares = new HashMap<>();

    for (int i = 0; i < 9; i++) {
      Set<Integer> currentRow = rows.get(i);
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == 0) continue;
        if (currentRow == null) {
          currentRow = new HashSet<>();
          rows.put(i, currentRow);
        }
        boolean rowUpdated = currentRow.add(board[i][j]);
        if (!rowUpdated) return false;

        Set<Integer> currentColumn = columns.get(j);
        if (currentColumn == null) {
          currentColumn = new HashSet<>();
          columns.put(j, currentColumn);
        }
        boolean columnUpdated = currentColumn.add(board[i][j]);
        if (!columnUpdated) return false;
        // i == 4, j == 0
        String square = String.format("%d%d", i / 3, j / 3);
        Set<Integer> currentSquare = squares.get(square);
        if (currentSquare == null) {
          currentSquare = new HashSet<>();
          squares.put(square, currentSquare);
        }
        boolean squaresUpdated = currentSquare.add(board[i][j]);
        if (!squaresUpdated) return false;
      }
    }

    return true;
  }
}
