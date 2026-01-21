package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IslandPerimeter463Test {
  class Solution {
    public int islandPerimeter(int[][] grid) {
      boolean[][] visited = new boolean[grid.length][grid[0].length];

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 1) {
            return dfs(i, j, grid, visited);
          }
        }
      }

      return 0;
    }

    int dfs(int row, int col, int[][] grid, boolean[][] visited) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
        return 1;
      }

      if (visited[row][col]) {
        return 0;
      }

      visited[row][col] = true;

      return dfs(row + 1, col, grid, visited) +
          dfs(row - 1, col, grid, visited) +
          dfs(row, col + 1, grid, visited) +
          dfs(row, col - 1, grid, visited);
    }
  }

  @Test
  void test() {
    assertEquals(16, new Solution().islandPerimeter(new int[][]{
        {0, 1, 0, 0},
        {1, 1, 1, 0},
        {0, 1, 0, 0},
        {1, 1, 0, 0}
    }));
  }
}
