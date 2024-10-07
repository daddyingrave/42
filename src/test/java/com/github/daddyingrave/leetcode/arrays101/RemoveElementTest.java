package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

  @Test
  void removeElement() {
    var problem = new RemoveElement();

    int[] given = new int[]{3, 2, 2, 3};
    int[] expected = new int[]{2, 2, 0, 0};

    problem.removeElement(given, 3);

    assertArrayEquals(expected, given);
  }

  @Test
  void removeElement2() {
    var problem = new RemoveElement();

    int[] given = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    int[] expected = new int[]{0, 1, 4, 0, 3, 0, 0, 0};

    problem.removeElement(given, 2);

    assertArrayEquals(expected, given);
  }
}