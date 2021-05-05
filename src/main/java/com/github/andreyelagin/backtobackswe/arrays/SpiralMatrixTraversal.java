package com.github.andreyelagin.backtobackswe.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> flatSpiral = new ArrayList<>();

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      for (int k = left; k <= right; k++) {
        flatSpiral.add(matrix[top][k]);
      }
      top++;

      for (int k = top; k <= bottom; k++) {
        flatSpiral.add(matrix[k][right]);
      }
      right--;

      if (top <= bottom) {
        for (int k = right; k >= left; k--) {
          flatSpiral.add(matrix[bottom][k]);
        }
        bottom--;
      }
      
      if (left <= right) {
        for (int k = bottom; k >= top; k--) {
          flatSpiral.add(matrix[k][left]);
        }
        left++;
      }
    }

    return flatSpiral;
  }
}
