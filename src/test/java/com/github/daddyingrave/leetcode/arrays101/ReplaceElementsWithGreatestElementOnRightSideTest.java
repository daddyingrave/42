package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceElementsWithGreatestElementOnRightSideTest {

  @Test
  void replaceElements() {
    var problem = new ReplaceElementsWithGreatestElementOnRightSide();

    int[] expected = new int[]{18, 6, 6, 6, 1, -1};
    int[] actual = new int[]{17, 18, 5, 4, 6, 1};

    assertArrayEquals(expected, problem.replaceElements(actual));
  }
}