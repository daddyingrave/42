package com.github.daddyingrave.leetcode.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

  @Test
  void firstBadVersion() {
    var problem = new FirstBadVersion();

    assertEquals(4, problem.firstBadVersion(5));
  }
}