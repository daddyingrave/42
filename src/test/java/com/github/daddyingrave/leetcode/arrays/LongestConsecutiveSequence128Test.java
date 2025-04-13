package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequence128Test {

  @Test
  void longestConsecutive() {
    var problem = new LongestConsecutiveSequence128();

    assertEquals(4, problem.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    assertEquals(9, problem.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    assertEquals(3, problem.longestConsecutive(new int[]{1, 0, 1, 2}));
    assertEquals(3, problem.longestConsecutive(new int[]{1, 0, -1}));
  }
}
