package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleIITest {

  PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();

  @Test
  void getRow() {
    int givenRowIndex = 3;
    var expectedRow = List.of(1, 3, 3, 1);
    var actualRow = pascalsTriangleII.getRow(givenRowIndex);

    assertEquals(expectedRow, actualRow);
  }

  @Test
  void getRow2() {
    int givenRowIndex = 0;
    var expectedRow = List.of(1);
    var actualRow = pascalsTriangleII.getRow(givenRowIndex);

    assertEquals(expectedRow, actualRow);
  }

  @Test
  void getRow3() {
    int givenRowIndex = 1;
    var expectedRow = List.of(1, 1);
    var actualRow = pascalsTriangleII.getRow(givenRowIndex);

    assertEquals(expectedRow, actualRow);
  }
}