package com.github.daddyingrave.backtobackswe.searching;

public class Search2DSortedMatrix {
  public boolean search(int[][] matrix, int target) {
    int x = 0;
    int y = matrix.length - 1;
    
    while (y >= 0 && x <= matrix[0].length - 1) {
      if (matrix[y][x] == target) {
        return true;
      } else if (matrix[y][x] < target) {
        x++;
      } else {
        y--;
      }
    }
    
    return false;
  }
  
//  public boolean search(int[][] matrix, int target) {
//    int y = matrix.length / 2;
//    int x = matrix[0].length / 2;
//    int l = 0;
//    int r = matrix.length - 1;
//
//    while (true) {
//      if (matrix[y][x] == target) {
//        return true;
//      } else if (matrix[y][x] < target) {
//        int[] arr = matrix[y];
//        var find = binarySearch(arr, target, x);
//        if (find != -1) {
//          return true;
//        } else {
//          if (matrix[y][matrix[y].length - 1] > target) {
//            r = y;
//          } else {
//            l = y;
//          }
//          y = l + ((r - l) / 2);
//        }
//      } else {
//
//      }
//    }
//    return true;
//  }
//
//  private int binarySearch(int[] arr, int elem, int mid) {
//    int l, r;
//    if (arr[mid] < elem) {
//      l = mid;
//      r = arr.length - 1;
//    } else {
//      l = 0;
//      r = mid;
//    }
//    mid = l + ((r - l) / 2);
//
//    while (l <= r) {
//      if (arr[mid] == elem) {
//        return mid;
//      } else if (arr[mid] < elem) {
//        l = mid;
//      } else {
//        r = mid;
//      }
//      mid = l + ((r - l) / 2);
//    }
//    
//    return -1;
//  }
}
