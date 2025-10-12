package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseLinkedList206Test {
  class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      var cur = head;
      while (cur != null) {
        var next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }

      return prev;
    }
  }

  @Test
  void test() {

  }
}
