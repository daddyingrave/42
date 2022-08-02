package com.github.daddyingrave.leetcode.linkedlists;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode prev = null;
    ListNode cur = head;
    
    while (cur != null) {
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    
    return prev;
  }
}
