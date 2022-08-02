package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

class PascalsTriangleTest {

  PascalsTriangle pascalsTriangle = new PascalsTriangle();
  
  @Test
  void generate() {
    System.out.println(pascalsTriangle.generate(5));
  }
}