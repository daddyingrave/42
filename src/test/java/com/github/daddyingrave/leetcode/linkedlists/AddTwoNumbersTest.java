package com.github.daddyingrave.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

  AddTwoNumbers solution = new AddTwoNumbers();

  @Test
  void addTwoNumbers() {
    var l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    var l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    assertEquals(
        List.of(7, 0, 8),
        solution.addTwoNumbers(l1, l2).toList()
    );
  }

  @Test
  void addTwoNumbers2() {
    var l1 = new ListNode(0);

    var l2 = new ListNode(0);

    assertEquals(
        List.of(0),
        solution.addTwoNumbers(l1, l2).toList()
    );
  }

  @Test
  void addTwoNumbers3() {
    assertEquals(
        List.of(8, 9, 9, 9, 0, 0, 0, 1),
        solution.addTwoNumbers(
            ListNode.fromList(List.of(9, 9, 9, 9, 9, 9, 9)),
            ListNode.fromList(List.of(9, 9, 9, 9))
        ).toList()
    );
  }
}