package com.github.andreyelagin.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestingForCyclesTest {

  TestingForCycles cycles = new TestingForCycles();
  
  @Test
  void hasCycle() {
    var headWithCycle = ListNode.build(List.of(1, 2, 3, 4, 5));
    var cur = headWithCycle;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = headWithCycle;

    var headWithoutCycle = ListNode.build(List.of(1, 2, 3, 4, 5));

    assertTrue(cycles.hasCycle(headWithCycle));
    assertFalse(cycles.hasCycle(headWithoutCycle));
  }
}