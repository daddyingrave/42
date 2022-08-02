package com.github.daddyingrave.leetcode.graphs;

public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j]) {
          count += traverse(grid, visited, i, j);
        }
      }
    }

    return count;
  }

  private int traverse(char[][] grid, boolean[][] visited, int row, int col) {
    visited[row][col] = true;
    
    if (grid[row][col] != '1') {
      return 0;
    }
    
    // right
    if (col + 1 < grid[row].length && !visited[row][col + 1]) {
      traverse(grid, visited, row, col + 1);
    }

    // bottom
    if (row + 1 < grid.length && !visited[row + 1][col]) {
      traverse(grid, visited, row + 1, col);
    }

    // top
    if (row - 1 >= 0 && !visited[row - 1][col]) {
      traverse(grid, visited, row - 1, col);
    }

    // left
    if (col - 1 >= 0 && !visited[row][col - 1]) {
      traverse(grid, visited, row, col - 1);
    }
    
    return 1;
  }
}
