package com.github.daddyingrave.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneWayTest {

  OneWay oneWay = new OneWay();
  
  @Test
  void isOneWay() {
    assertTrue(oneWay.isOneWay("pale", "ple"));
    assertTrue(oneWay.isOneWay("pales", "pale"));
    assertTrue(oneWay.isOneWay("pale", "bale"));
    assertFalse(oneWay.isOneWay("pale", "bake"));
  }
}