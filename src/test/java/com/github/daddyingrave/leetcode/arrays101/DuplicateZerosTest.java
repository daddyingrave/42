package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateZerosTest {

  @Test
  void duplicateZeros() {
    var problem = new DuplicateZeros();

    var arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
    var arrExpected = new int[]{1, 0, 0, 2, 3, 0, 0, 4};

    problem.duplicateZeros(arr);

    assertArrayEquals(arrExpected, arr);
  }
}