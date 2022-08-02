package com.github.daddyingrave.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddIntegersRepresentedAsLinkedListsTest {

  AddIntegersRepresentedAsLinkedLists addLists = new AddIntegersRepresentedAsLinkedLists();

  @Test
  void addTwoNumbers() {
    assertEquals(
        ListNode.build(List.of(7, 1, 8)),
        addLists.addTwoNumbers(
            ListNode.build(List.of(2, 2, 5)),
            ListNode.build(List.of(5, 9, 2))
        )
    );
    assertEquals(
        ListNode.build(List.of(7, 1, 3)),
        addLists.addTwoNumbers(
            ListNode.build(List.of(2, 2)),
            ListNode.build(List.of(5, 9, 2))
        )
    );
    assertEquals(
        ListNode.build(List.of(7, 0, 5)),
        addLists.addTwoNumbers(
            ListNode.build(List.of(2, 1, 2)),
            ListNode.build(List.of(5, 9, 2))
        )
    );
    assertEquals(
        ListNode.build(List.of(8, 9, 9, 1)),
        addLists.addTwoNumbers(
            ListNode.build(List.of(9, 9, 9)),
            ListNode.build(List.of(9, 9, 9))
        )
    );
  }
}