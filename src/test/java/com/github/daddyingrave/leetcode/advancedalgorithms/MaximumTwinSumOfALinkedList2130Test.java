package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumTwinSumOfALinkedList2130Test {
  public int pairSum(ListNode head) {

    var slow = head;
    var fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    var leftMid = reverse(head, slow);

    int maxSum = 0;
    while (slow != null) {
      maxSum = Math.max(maxSum, leftMid.val + slow.val);
      slow = slow.next;
      leftMid = leftMid.next;
    }

    return maxSum;
  }

  ListNode reverse(ListNode start, ListNode mid) {
    ListNode cur = start;
    ListNode prev = null;

    while (cur != null && cur.next != null) {
      if (cur == mid) {
        break;
      }
      var nextTmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = nextTmp;
    }

    return prev;
  }

  @Test
  void test() {
    var node5 = new ListNode(5, null);
    var node4 = new ListNode(4, node5);
    var node2 = new ListNode(2, node4);
    var node1 = new ListNode(1, node2);

    assertEquals(6, pairSum(node1));
  }
}
