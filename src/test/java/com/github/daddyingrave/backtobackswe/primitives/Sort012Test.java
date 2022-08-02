package com.github.daddyingrave.backtobackswe.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sort012Test {

  @Test
  void sortArray_0_1_2() {
    assertArrayEquals(
        new int[]{0, 0, 1, 1, 1, 2, 2, 2, 2},
        Sort012.sortArray_0_1_2(new int[]{0, 1, 2, 1, 2, 2, 2, 1, 0})
    );
  }
}