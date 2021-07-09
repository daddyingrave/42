package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleTest {

  PascalsTriangle pascalsTriangle = new PascalsTriangle();
  
  @Test
  void generate() {
    System.out.println(pascalsTriangle.generate(5));
  }
}