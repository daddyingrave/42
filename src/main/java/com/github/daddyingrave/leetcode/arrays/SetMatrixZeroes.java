package com.github.daddyingrave.leetcode.arrays;

import java.util.Arrays;

public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    boolean colUpdate = false;
    
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colUpdate = true;
      }
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[i].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }  
      }
    }

    if (matrix[0][0] == 0) {
      Arrays.fill(matrix[0], 0);
    }
    
    if (colUpdate) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
