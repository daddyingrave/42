package com.github.daddyingrave.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {

  FourSum fourSum = new FourSum();

  @Test
  void four_Sum() {
    assertEquals(
        6,
        fourSum.fourSum(
            new int[]{3, 2, 1},
            new int[]{4, -1, -2},
            new int[]{-1, 2, -4},
            new int[]{2, 0, 3}
        )
    );
  }
}