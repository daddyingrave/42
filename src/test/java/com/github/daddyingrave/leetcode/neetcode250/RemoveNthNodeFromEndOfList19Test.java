package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveNthNodeFromEndOfList19Test {
  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      var dummy = new ListNode();
      dummy.next = head;
      var prev = dummy;
      var slow = dummy.next;
      var fast = dummy.next;

      while (fast != null) {
        if (n <= 0) {
          prev = slow;
          slow = slow.next;
        } else {
          n--;
        }

        fast = fast.next;
      }

      prev.next = slow.next;

      return dummy.next;
    }
  }

  @Test
  void test() {

  }
}
