package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class RangeSumQuery2DImmutable304TestTest {
  class NumMatrix {
    int[][] prefixes;

    public NumMatrix(int[][] matrix) {
      prefixes = new int[matrix.length + 1][matrix[0].length + 1];

      for (int row = 0; row < matrix.length; row++) {
        int prefix = 0;
        for (int col = 0; col < matrix[row].length; col++) {
          prefix += matrix[row][col];
          prefixes[row + 1][col + 1] = prefix + prefixes[row][col + 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      row1++;
      col1++;
      row2++;
      col2++;

      int sum = prefixes[row2][col2];
      sum -= prefixes[row1 - 1][col2];
      sum -= prefixes[row2][col1 - 1];
      sum += prefixes[row1 - 1][col1 - 1];

      return sum;
    }
  }

  @Test
  void test() {
    int[][] matrix = new int[][]{
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
    };
    NumMatrix mat = new NumMatrix(matrix);
    System.out.println();
  }
}
