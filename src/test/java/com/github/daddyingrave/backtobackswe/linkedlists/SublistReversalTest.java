package com.github.daddyingrave.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SublistReversalTest {

  SublistReversal reversal = new SublistReversal();

  @Test
  void reverseBetween() {
    assertEquals(
        ListNode.build(List.of(4, 3, 2, 1)),
        reversal.reverseBetween(ListNode.build(List.of(1, 2, 3, 4)), 1, 4)
    );
    assertEquals(
        ListNode.build(List.of(1, 2)),
        reversal.reverseBetween(ListNode.build(List.of(1, 2)), 1, 1)
    );
    assertEquals(
        ListNode.build(List.of(1, 4, 3, 2, 5)),
        reversal.reverseBetween(ListNode.build(List.of(1, 2, 3, 4, 5)), 2, 4)
    );
  }
}