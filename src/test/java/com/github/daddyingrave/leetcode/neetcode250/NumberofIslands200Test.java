package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberofIslands200Test {
  class Solution {
    public int numIslands(char[][] grid) {
      int count = 0;

      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
          if (grid[row][col] == '1') {
            dfs(row, col, grid);
            count++;
          }
        }
      }

      return count;
    }

    void dfs(int row, int col, char[][] grid) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length ||
          grid[row][col] == '0' || grid[row][col] == '*') {
        return;
      }

      grid[row][col] = '*';

      dfs(row + 1, col, grid);
      dfs(row - 1, col, grid);
      dfs(row, col + 1, grid);
      dfs(row, col - 1, grid);
    }
  }

  @Test
  void test() {

  }
}
