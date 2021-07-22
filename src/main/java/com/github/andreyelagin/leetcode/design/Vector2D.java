package com.github.andreyelagin.leetcode.design;

class Vector2D {

  private final int[][] vec;
  private int row;
  private int col;

  public Vector2D(int[][] vec) {
    this.vec = vec;
  }

  public int next() {
    while (vec[row].length == 0) {
      row++;
      col = 0;
    }
    
    int cur = vec[row][col];

    if (col >= vec[row].length - 1) {
      row++;
      col = 0;
    } else {
      col++;
    }

    return cur;
  }

  public boolean hasNext() {
    int curRow = row;
    int curCol = col;
    
    while (curRow < vec.length) {
      if (vec[curRow].length == 0) {
        curRow++;
        curCol = 0;
      } else if (curCol < vec[curRow].length) {
        return true;
      } else {
        curRow++;
      }
    }

    return false;
  }
}
