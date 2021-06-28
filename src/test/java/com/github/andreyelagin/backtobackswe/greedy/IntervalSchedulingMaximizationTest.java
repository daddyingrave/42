package com.github.andreyelagin.backtobackswe.greedy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntervalSchedulingMaximizationTest {

  IntervalSchedulingMaximization maximization = new IntervalSchedulingMaximization();

  @Test
  void constructOptimalSchedule() {
    assertArrayEquals(
        new int[][]{new int[]{0, 3}},
        maximization.constructOptimalSchedule(
            new int[][]{
                new int[]{0, 3},
                new int[]{0, 6},
            }
        ).toArray()
    );
    assertArrayEquals(
        new int[][]{
            new int[]{0, 3},
            new int[]{8, 11},
            new int[]{19, 23},
        },
        maximization.constructOptimalSchedule(
            new int[][]{
                new int[]{0, 3},
                new int[]{0, 6},
                new int[]{0, 17},
                new int[]{8, 11},
                new int[]{19, 23}
            }
        ).toArray()
    );
  }
}