package com.github.daddyingrave.backtobackswe.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToTraverseMatrixTest {

  NumberOfWaysToTraverseMatrix traverseMatrix = new NumberOfWaysToTraverseMatrix();
  
  @Test
  void uniquePaths() {
    assertEquals(6, traverseMatrix.uniquePaths(3, 3));
    assertEquals(120, traverseMatrix.uniquePaths(4, 8));
  }
}