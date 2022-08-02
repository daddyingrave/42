package com.github.daddyingrave.backtobackswe.dynamicprogramming;

public class NumberOfWaysToTraverseMatrix {
  public int uniquePaths(int rows, int cols) {
    int[][] matrix = new int[rows][cols];

    for (int i = 0; i < cols; i++) {
      matrix[0][i] = 1;
    }

    for (int i = 0; i < rows; i++) {
      matrix[i][0] = 1;
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
      }
    }
    
    return matrix[rows - 1][cols - 1];
  }
}
