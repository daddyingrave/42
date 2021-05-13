package com.github.andreyelagin.backtobackswe.linkedlists;

import java.util.List;
import java.util.Objects;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    var cur = next;
    sb.append("[").append(val).append("]").append(", ");
    while (cur != null) {
      sb.append("[").append(cur.val).append("]").append(", ");
      cur = cur.next;
    }
    return sb.toString();
  }
  
  public static ListNode build(List<Integer> values) {
    ListNode head = new ListNode(values.get(0));
    var cur = head;
    for (int i = 1; i < values.size(); i++) {
      var node = new ListNode(values.get(i));
      cur.next = node;
      cur = node;
    }
    return head;
  }
}
