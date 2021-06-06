package com.github.andreyelagin.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputeIntegerSquareRootTest {

  ComputeIntegerSquareRoot root = new ComputeIntegerSquareRoot();
  
  @Test
  void squareRoot() {
    assertEquals(5, root.squareRoot(25));
    assertEquals(2, root.squareRoot(8));
  }
}