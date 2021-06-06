package com.github.andreyelagin.backtobackswe.searching;

public class Search2DSortedMatrix2 {
  public boolean search2(int[][] matrix, int target) {
    int cols = matrix[0].length;
    int rows = matrix.length;

    int left = 0;
    int right = rows * cols - 1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);
      int midValue = matrix[mid / cols][mid % cols];
      if (midValue == target) {
        return true;
      } else if (midValue < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    return false;
  }
}
