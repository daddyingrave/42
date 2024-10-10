package com.github.daddyingrave.leetcode.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

  @Test
  void moveZeroes() {
    var problem = new MoveZeroes();

    int[] actual = new int[]{0, 1, 0, 3, 12};
    int[] expected = new int[]{1, 3, 12, 0, 0};

    problem.moveZeroes(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  void moveZeroes2() {
    var problem = new MoveZeroes();

    int[] actual = new int[]{0};
    int[] expected = new int[]{0};

    problem.moveZeroes(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  void moveZeroes3() {
    var problem = new MoveZeroes();

    int[] actual = new int[]{1};
    int[] expected = new int[]{1};

    problem.moveZeroes(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  void moveZeroes4() {
    var problem = new MoveZeroes();

    int[] actual = new int[]{1, 0};
    int[] expected = new int[]{1, 0};

    problem.moveZeroes(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  void moveZeroes5() {
    var problem = new MoveZeroes();

    int[] actual = new int[]{1, 0, 1};
    int[] expected = new int[]{1, 1, 0};

    problem.moveZeroes(actual);

    assertArrayEquals(expected, actual);
  }
}