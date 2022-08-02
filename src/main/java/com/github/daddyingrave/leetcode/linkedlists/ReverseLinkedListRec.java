package com.github.daddyingrave.leetcode.linkedlists;

public class ReverseLinkedListRec {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    var tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }

    rec(null, head);

    return tail;
  }

  private void rec(ListNode f, ListNode s) {
    if (s == null) {
      return;
    }

    var temp = s.next;
    s.next = f;
    rec(s, temp);
  }
}
