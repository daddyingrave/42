package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniquePathsII63Test {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int rows = obstacleGrid.length;
    int cols = obstacleGrid[0].length;

    if (obstacleGrid[rows - 1][cols - 1] == 1 || obstacleGrid[0][0] == 1) {
      return 0;
    }

    obstacleGrid[rows - 1][cols - 1] = 1;

    for (int i = obstacleGrid.length - 1; i >= 0; i--) {
      for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
        if (i == rows - 1 && j == cols - 1) {
          continue;
        }

        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else {
          int paths = obstacleGrid[i][j];
          if (i + 1 < rows) {
            paths += obstacleGrid[i + 1][j];
          }
          if (j + 1 < cols) {
            paths += obstacleGrid[i][j + 1];
          }

          obstacleGrid[i][j] = paths;
        }
      }
    }

    return obstacleGrid[0][0];
  }

  @Test
  void test() {
    assertEquals(2, uniquePathsWithObstacles(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    }));
    assertEquals(0, uniquePathsWithObstacles(new int[][]{
        {0, 0, 0},
        {1, 1, 1},
        {0, 0, 0}
    }));
    assertEquals(1, uniquePathsWithObstacles(new int[][]{
        {0, 1},
        {0, 0},
    }));
    assertEquals(0, uniquePathsWithObstacles(new int[][]{
        {0, 1},
        {1, 0},
    }));
    assertEquals(0, uniquePathsWithObstacles(new int[][]{
        {1, 0},
    }));
    assertEquals(0, uniquePathsWithObstacles(new int[][]{
        {0, 0},
        {0, 1},
    }));
  }
}
