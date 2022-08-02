package com.github.daddyingrave.backtobackswe.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputeTheMedianOnlineDataTest {

  @Test
  void median() {
    var median = new ComputeTheMedianOnlineData();
    median.insert(14);
    assertEquals(14.0, median.median());
    median.insert(6);
    assertEquals(10.0, median.median());
    median.insert(30);
    assertEquals(14.0, median.median());
    median.insert(35);
    assertEquals(22.0, median.median());
  }
}