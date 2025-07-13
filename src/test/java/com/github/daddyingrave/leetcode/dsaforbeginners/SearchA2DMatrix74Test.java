package com.github.daddyingrave.leetcode.dsaforbeginners;

public class SearchA2DMatrix74Test {

  // [1  , 3  , 5  , 7],
  // [10 , 11 , 16 , 20],
  // [23 , 30 , 34 , 60]
  public boolean searchMatrix(int[][] matrix, int target) {
    int left = 0;
    int right = matrix.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
        return binarySearch(matrix[mid], target);
      } else if (target < matrix[mid][0]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return false;
  }

  boolean binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target < arr[mid]) {
        right = mid - 1;
      } else if (target > arr[mid]) {
        left = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
