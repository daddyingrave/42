package com.github.andreyelagin.backtobackswe.arrays;

public class Rotate2DMatrix {
  public int[][] rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      int inc = i;
      int dec = matrix.length - i - 1;
      while (inc < matrix.length - i && dec > i) {
        swap(matrix, i, inc, inc, matrix.length - i - 1);
        swap(matrix, i, matrix.length - i - 1, inc, dec);
        swap(matrix, i, dec, inc, i);
        inc++;
        dec--;
      }
    }
    return matrix;
  }

  private void swap(int[][] m, int fromX, int toX, int fromY, int toY) {
    int temp = m[toX][toY];
    m[toX][toY] = m[fromX][fromY];
    m[fromX][fromY] = temp;
  }
}
