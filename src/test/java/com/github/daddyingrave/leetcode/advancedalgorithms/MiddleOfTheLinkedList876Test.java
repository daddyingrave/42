package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MiddleOfTheLinkedList876Test {
  public ListNode middleNode(ListNode head) {
    var slow = head;
    var fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  @Test
  void test() {

  }
}
