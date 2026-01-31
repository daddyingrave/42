package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IslandsandTreasureTest {
  class Solution {
    public void islandsAndTreasure(int[][] grid) {
      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
          if (grid[row][col] == 0) {
            dfs(row, col, 0, grid, new boolean[grid.length][grid[row].length]);
          }
        }
      }
    }

    void dfs(int row, int col, int distance, int[][] grid, boolean[][] visited) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length ||
          grid[row][col] == -1 || visited[row][col]
      ) {
        return;
      }

      if (grid[row][col] == Integer.MAX_VALUE) {
        grid[row][col] = distance;
      } else if (grid[row][col] != 0 && distance > grid[row][col]) {
        return;
      } else if (grid[row][col] != 0) {
        grid[row][col] = Math.min(grid[row][col], distance);
      }

      visited[row][col] = true;

      dfs(row + 1, col, distance + 1, grid, visited);
      dfs(row - 1, col, distance + 1, grid, visited);
      dfs(row, col + 1, distance + 1, grid, visited);
      dfs(row, col - 1, distance + 1, grid, visited);

      visited[row][col] = false;
    }
  }

  @Test
  void test() {
    new Solution().islandsAndTreasure(new int[][]{
        {2147483647, -1, 0, 2147483647},
        {2147483647, 2147483647, 2147483647, -1},
        {2147483647, -1, 2147483647, -1},
        {0, -1, 2147483647, 2147483647}
    });
  }
}
