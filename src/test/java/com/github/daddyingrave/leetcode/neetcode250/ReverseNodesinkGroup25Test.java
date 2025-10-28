package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseNodesinkGroup25Test {
  class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      var dummy = new ListNode();
      dummy.next = head;
      var groupPrev = dummy;

      while (true) {
        var kthNode = getKth(groupPrev, k);
        if (kthNode == null) {
          break;
        }

        var groupNext = kthNode.next;

        var prev = kthNode.next;
        var cur = groupPrev.next;
        while (cur != groupNext) {
          var tmp = cur.next;
          cur.next = prev;
          prev = cur;
          cur = tmp;
        }

        var tmp = groupPrev.next;
        groupPrev.next = kthNode;
        groupPrev = tmp;
      }

      return dummy.next;
    }

    ListNode getKth(ListNode cur, int k) {
      while (cur != null && k > 0) {
        cur = cur.next;
        k--;
      }

      return cur;
    }
  }

  @Test
  void test() {

  }
}
