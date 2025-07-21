package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixDepthFirstSearchTest {
  public int countPaths(int[][] grid) {
    return dfs(grid, 0, 0, new HashSet<>());
  }

  int dfs(int[][] grid, int row, int col, Set<String> set) {
    int totalRows = grid.length;
    int totalCols = grid[0].length;
    if (row >= totalRows || col >= totalCols) {
      return 0;
    } else if (row < 0 || col < 0) {
      return 0;
    } else if (grid[row][col] == 1) {
      return 0;
    } else if (set.contains("" + row + col)) {
      return 0;
    } else if (row == totalRows - 1 && col == totalCols - 1) {
      return 1;
    }

    set.add("" + row + col);

    int count = 0;
    count += dfs(grid, row + 1, col, set);
    count += dfs(grid, row, col + 1, set);
    count += dfs(grid, row - 1, col, set);
    count += dfs(grid, row, col - 1, set);

    set.remove("" + row + col);

    return count;
  }

  @Test
  void test() {
    assertEquals(2, countPaths(new int[][]{
        {0, 0, 0, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 1},
        {0, 1, 0, 0}
    }));
  }
}
