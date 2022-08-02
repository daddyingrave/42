package com.github.daddyingrave.backtobackswe.linkedlists;

import java.util.HashMap;

public class RemoveElementFromTheEnd {
  public ListNode removeKthToLast(ListNode head, int k) {
    var dummy = new ListNode(666);
    dummy.next = head;

    var right = dummy.next;
    while (k > 0) {
      right = right.next;
      k--;
    }

    var left = dummy;
    while (right != null) {
      left = left.next;
      right = right.next;
    }

    left.next = left.next.next;

    return dummy.next;
  }

  public ListNode removeKthToLastMy(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    var map = new HashMap<Integer, ListNode>();
    var index = 0;
    var cur = head;

    while (cur != null) {
      map.put(index++, cur);
      cur = cur.next;
    }

    if (map.size() - k - 1 <= 0) {
      return head.next;
    }

    map.get(map.size() - k - 1).next = map.get(map.size() - k + 1);

    return head;
  }
}
