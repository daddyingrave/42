package com.github.andreyelagin.leetcode.search;

public class Search2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    return spiralSearch(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
  }

  private boolean spiralSearch(int[][] m, int target, int top, int bottom, int left, int right) {
    if (top > bottom || left > right) {
      return false;
    }

    int yMid = top + (bottom - top) / 2;
    int xMid = left + (right - left) / 2;

    if (m[yMid][xMid] == target) {
      return true;
    } else if (target < m[yMid][xMid]) {
      return spiralSearch(m, target, top, bottom, left, xMid - 1)
          || spiralSearch(m, target, top, yMid - 1, xMid, right);
    } else {
      return spiralSearch(m, target, yMid + 1, bottom, left, right)
          || spiralSearch(m, target, top, yMid, xMid + 1, right);
    }
  }
}
