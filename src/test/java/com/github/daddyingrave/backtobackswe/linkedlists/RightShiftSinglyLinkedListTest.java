package com.github.daddyingrave.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RightShiftSinglyLinkedListTest {

  RightShiftSinglyLinkedList shift = new RightShiftSinglyLinkedList();

  @Test
  void rotateRight() {
    assertEquals(
        ListNode.build(List.of(3, 4, 1, 2)),
        shift.rotateRight(ListNode.build(List.of(1, 2, 3, 4)), 2)
    );
    assertEquals(
        ListNode.build(List.of(1, 2, 3, 4)),
        shift.rotateRight(ListNode.build(List.of(1, 2, 3, 4)), 4)
    );
    assertEquals(
        ListNode.build(List.of(5, 1, 2, 3, 4)),
        shift.rotateRight(ListNode.build(List.of(1, 2, 3, 4, 5)), 1)
    );
    assertEquals(
        ListNode.build(List.of(3, 2, 1, 5, 4)),
        shift.rotateRight(ListNode.build(List.of(5, 4, 3, 2, 1)), 3)
    );
  }
}