package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import java.util.HashSet;

public class NumberOfDistinctIslands {
  // left up right bottom
  private final int[] rowDirection = new int[]{-1, 0, 1, 0};
  private final int[] colDirection = new int[]{0, -1, 0, 1};

  public int numberOfDistinctIslands(int[][] grid) {
    var islands = new HashSet<String>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          var state = new StringBuilder();
          backtrack(grid, state, j, i);
          islands.add(state.toString());
        }
      }
    }

    return islands.size();
  }

  private void backtrack(int[][] map, StringBuilder state, int col, int row) {
    map[row][col] = 0;

    for (int i = 0; i < rowDirection.length; i++) {
      int newRow = row + rowDirection[i];
      int newCol = col + colDirection[i];

      if (inBounds(map, newCol, newRow) && map[newRow][newCol] == 1) {
        state.append(i);
        backtrack(map, state, newCol, newRow);
      }
    }

    state.append(",");
  }

  private boolean inBounds(int[][] map, int col, int row) {
    return row >= 0 && row < map.length && col >= 0 && col < map[row].length;
  }
}
