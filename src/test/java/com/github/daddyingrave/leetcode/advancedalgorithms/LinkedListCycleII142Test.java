package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

public class LinkedListCycleII142Test {
  public ListNode detectCycle(ListNode head) {
    var slow = head;
    var fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        var newSlow = head;
        while (newSlow != slow) {
          slow = slow.next;
          newSlow = newSlow.next;
        }

        return newSlow;
      }
    }

    return null;
  }

  @Test
  void test() {

  }
}
