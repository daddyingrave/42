package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RottingOranges994Test {
  class Solution {
    public int orangesRotting(int[][] grid) {
      int totalToRot = 0;

      boolean[][] visited = new boolean[grid.length][grid[0].length];
      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
          if (grid[row][col] == 2) {
            dfs(row, col, 0, grid, visited);
          }
        }
      }

      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
          if (grid[row][col] == 1) {
            return -1;
          } else if (grid[row][col] < 0) {
            totalToRot = Math.max(totalToRot, -grid[row][col]);
          }
        }
      }

      return totalToRot;
    }

    void dfs(int row, int col, int rotCounter, int[][] grid, boolean[][] visited) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length
          || grid[row][col] == 0 || visited[row][col]
      ) {
        return;
      }

      
      if (grid[row][col] == 1 || grid[row][col] < rotCounter) {
        grid[row][col] = rotCounter;
      }
      if (grid[row][col] < 0 && grid[row][col] > rotCounter) {
        return;
      }

      visited[row][col] = true;

      dfs(row + 1, col, rotCounter - 1, grid, visited);
      dfs(row - 1, col, rotCounter - 1, grid, visited);
      dfs(row, col + 1, rotCounter - 1, grid, visited);
      dfs(row, col - 1, rotCounter - 1, grid, visited);

      visited[row][col] = false;
    }
  }

  @Test
  void test() {
    new Solution().orangesRotting(new int[][]{
        {1, 1, 0},
        {0, 1, 1},
        {0, 1, 2}
    });
  }
}
