package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseLinkedListII92Test {
  class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      var dummy = new ListNode();
      dummy.next = head;
      var prev = dummy;

      for (int j = 0; j < left - 1; j++) {
         prev = prev.next;
      }

      var sublistHead = prev.next;
      var sublistTail = sublistHead;
      for (int j = 0; j < right - left; j++) {
        sublistTail = sublistTail.next;
      }

      var nextNode = sublistTail.next;
      sublistTail.next = null;
      prev.next = reverse(sublistHead);
      sublistHead.next = nextNode;

      return dummy.next;
    }

    ListNode reverse(ListNode head) {
      ListNode prev = null;
      ListNode cur = head;

      while (cur != null) {
        var tmp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = tmp;
      }

      return prev;
    }
  }

  @Test
  void test() {

  }
}
