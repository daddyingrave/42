package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

  PlusOne plusOne = new PlusOne();

  @Test
  void plusOne() {
    assertArrayEquals(
        new int[]{1, 2, 4},
        plusOne.plusOne(new int[]{1, 2, 3})
    );
    assertArrayEquals(
        new int[]{1, 3, 0},
        plusOne.plusOne(new int[]{1, 2, 9})
    );
    assertArrayEquals(
        new int[]{1, 0, 0, 0},
        plusOne.plusOne(new int[]{9, 9, 9})
    );
  }
}