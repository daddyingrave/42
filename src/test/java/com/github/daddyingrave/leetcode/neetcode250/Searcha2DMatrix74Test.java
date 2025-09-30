package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

public class Searcha2DMatrix74Test {
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int total = rows * cols - 1;

      int left = 0;
      int right = total;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        int row = mid / cols;
        int col = mid % cols;
        if (target == matrix[row][col]) {
          return true;
        } else if (target < matrix[row][col]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return false;
    }
  }

  @Test
  void test() {

  }
}
