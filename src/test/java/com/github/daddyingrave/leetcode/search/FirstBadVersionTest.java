package com.github.daddyingrave.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

  @Test
  void firstBadVersion() {
    var bad = new FirstBadVersion(6);
    assertEquals(6, bad.firstBadVersion(7));

    var bad2 = new FirstBadVersion(4);
    assertEquals(4, bad2.firstBadVersion(5));

    var bad3 = new FirstBadVersion(1);
    assertEquals(1, bad3.firstBadVersion(1));

    var bad4 = new FirstBadVersion(1);
    assertEquals(1, bad4.firstBadVersion(2));
  }
}