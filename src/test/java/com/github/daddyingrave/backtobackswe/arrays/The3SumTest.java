package com.github.daddyingrave.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class The3SumTest {

  The3Sum sum = new The3Sum();

  @Test
  void threeSum() {
    assertEquals(
        List.of(
            List.of(-3, 1, 2),
            List.of(-2, 0, 2),
            List.of(-1, 0, 1)
        ),
        sum.threeSum(new int[]{-3, -1, 1, 0, 2, 10, -2, 8})
    );
    assertEquals(
        List.of(
            List.of(-5, 2, 3),
            List.of(-1, 0, 1)
        ),
        sum.threeSum(new int[]{-5, 3, 2, 0, 1, -1, -5, 3, 2})
    );
    assertEquals(
        List.of(),
        sum.threeSum(new int[]{1, 2, 3, 4})
    );
  }
}