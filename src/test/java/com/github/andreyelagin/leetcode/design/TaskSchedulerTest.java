package com.github.andreyelagin.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

  TaskScheduler solution = new TaskScheduler();

  @Test
  void leastInterval() {
    assertEquals(8, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    assertEquals(6, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    assertEquals(16, solution.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    assertEquals(10, solution.leastInterval(new char[]{'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'}, 4));
    assertEquals(104, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 50));
    assertEquals(8, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'E'}, 1));
    assertEquals(12, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'}, 2));
  }
}