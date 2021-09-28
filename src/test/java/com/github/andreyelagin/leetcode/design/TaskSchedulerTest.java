package com.github.andreyelagin.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

  TaskScheduler solution = new TaskScheduler();

  @Test
  void leastInterval() {
//    assertEquals(8, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
//    assertEquals(6, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    assertEquals(16, solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
  }
}