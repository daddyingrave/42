package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxAreaOfIsland695 {
  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    int maxRow = grid.length;
    int maxCol = grid[0].length;

    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, dfs(grid, i, j, maxRow, maxCol));
        }
      }
    }

    return max;
  }

  int dfs(int[][] grid, int row, int col, int rowMax, int colMax) {

    if (row >= rowMax || row < 0 || col >= colMax || col < 0 || grid[row][col] == 0) {
      return 0;
    }
    grid[row][col] = 0;
    int area = 1;

    area += dfs(grid, row + 1, col, rowMax, colMax);
    area += dfs(grid, row - 1, col, rowMax, colMax);
    area += dfs(grid, row, col + 1, rowMax, colMax);
    area += dfs(grid, row, col - 1, rowMax, colMax);

    if (area == 5) {
      System.out.println();
    }

    return area;
  }

  class Solution {
    public int maxAreaOfIsland(int[][] grid) {

      int maxArea = 0;
      int m = grid.length;
      int n = grid[0].length;

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1) {
            int area = dfs(grid, i, j, m, n);
            maxArea = Math.max(maxArea, area);
          }
        }
      }
      return maxArea;

    }

    private static int dfs(int[][] grid, int i, int j, int m, int n) {
      if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
        return 0;
      }
      grid[i][j] = 0;
      int area = 1;
      area += dfs(grid, i + 1, j, m, n);
      area += dfs(grid, i - 1, j, m, n);
      area += dfs(grid, i, j + 1, m, n);
      area += dfs(grid, i, j - 1, m, n);

      return area;
    }
  }

  @Test
  void test() {
    assertEquals(2, maxAreaOfIsland(new int[][]{{0, 0, 0, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 0}}));
  }

  @Test
  void test2() {
    assertEquals(6, maxAreaOfIsland(new int[][]{
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    }));
  }
}
