package com.github.daddyingrave.leetcode.arrays;

public class NumMatrix {
  int[][] matrix;
  int[][] prefixMatrix;

  // 21
  // 19
  // 16

  // 3, 0, 1, 4, 2
  // 5, 6, 3, 2, 1
  // 1, 2, 0, 1, 5
  // 4, 1, 0, 1, 7
  // 1, 0, 3, 0, 5

  // 0  0   0   0   0   0
  // 0, 3,  3,  4,  8,  10
  // 0, 8,  14, 18  24, 27
  // 0, 9,  17, 21, 28, 36
  // 0, 13, 22, 26, 34, 49
  // 0, 14, 23, 30, 38, 58

  //    0  1   2   3   4   5
  // ________________________
  // 0 [0, 0,  0,  0,  0,  0 ]"
  // 1 [0, 3,  3,  4,  8,  10]"
  // 2 [0, 8,  14, 18, 24, 27]"
  // 3 [0, 9,  17, 21, 28, 36]"
  // 4 [0, 13, 22, 26, 34, 49]"
  // 5 [0, 14, 23, 30, 38, 58]"

  // 2, 1, 4, 3
  public NumMatrix(int[][] matrix) {
    this.matrix = new int[matrix.length + 1][matrix[0].length + 1];
    for (int row = 0; row < matrix.length; row++) {
      System.arraycopy(matrix[row], 0, this.matrix[row + 1], 1, matrix[row].length);
    }

    this.prefixMatrix = new int[matrix.length + 1][matrix[0].length + 1];
    for (int row = 0; row < matrix.length; row++) {
      int currentRowPrefixSum = 0;
      for (int col = 0; col < matrix[0].length; col++) {
        currentRowPrefixSum += matrix[row][col];
        this.prefixMatrix[row + 1][col + 1] = currentRowPrefixSum + this.prefixMatrix[row][col + 1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = this.prefixMatrix[row2 + 1][col2 + 1];
    int reminder = this.prefixMatrix[row1][col1];

    sum -= this.prefixMatrix[row2 + 1][col1];
    sum -= this.prefixMatrix[row1][col2 + 1];

    return sum + reminder;
  }
}
