package com.github.andreyelagin.leetcode.linkedlists;

public class SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    var first = head;
    var second = head.next;

    first.next = swapPairs(second.next);
    second.next = head;

    return second;
  }
}
