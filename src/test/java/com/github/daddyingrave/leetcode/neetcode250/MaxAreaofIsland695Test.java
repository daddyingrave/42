package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxAreaofIsland695Test {
  class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int maxArea = 0;

      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
          if (grid[row][col] == 1) {
            maxArea = Math.max(maxArea, areaDfs(row, col, grid));
          }
        }
      }

      return maxArea;
    }

    int areaDfs(int row, int col, int[][] grid) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] != 1) {
        return 0;
      }

      grid[row][col] = -1;

      return 1 +
          areaDfs(row + 1, col, grid) +
          areaDfs(row - 1, col, grid) +
          areaDfs(row, col + 1, grid) +
          areaDfs(row, col - 1, grid);
    }
  }

  @Test
  void test() {
//    assertEquals(6, new Solution().maxAreaOfIsland(new ));
  }
}
