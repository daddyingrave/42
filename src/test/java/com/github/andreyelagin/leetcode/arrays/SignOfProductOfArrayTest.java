package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignOfProductOfArrayTest {

  SignOfProductOfArray solution = new SignOfProductOfArray();

  @Test
  void arraySign() {
    assertEquals(1, solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
    assertEquals(0, solution.arraySign(new int[]{1, 5, 0, 2, -3}));
    assertEquals(-1, solution.arraySign(new int[]{-1, 1, -1, 1, -1}));
  }
}