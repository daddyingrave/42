package com.github.daddyingrave.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rotate2DMatrixTest {

  Rotate2DMatrix matrixRotator = new Rotate2DMatrix();

  @Test
  void rotate() {
    int[][] m = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    int[][] expected = new int[][]{
        {13, 9, 5, 1},
        {14, 10, 6, 2},
        {15, 11, 7, 3},
        {16, 12, 8, 4}
    };
    assertArrayEquals(expected, matrixRotator.rotate(m));
  }

  @Test
  void rotate2() {
    int[][] m = new int[][]{
        {10, 20},
        {30, 40}
    };
    int[][] expected = new int[][]{
        {30, 10},
        {40, 20}
    };
    assertArrayEquals(expected, matrixRotator.rotate(m));
  }

  @Test
  void rotate3() {
    int[][] m = new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] expected = new int[][]{
        {7, 4, 1},
        {8, 5, 2},
        {9, 6, 3}
    };
    assertArrayEquals(expected, matrixRotator.rotate(m));
  }
}