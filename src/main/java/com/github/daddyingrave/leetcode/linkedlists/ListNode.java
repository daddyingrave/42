package com.github.daddyingrave.leetcode.linkedlists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public List<Integer> toList() {
    var list = new ArrayList<Integer>();

    var cur = this;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }

    return list;
  }

  public static ListNode fromList(List<Integer> source) {
    var dummy = new ListNode();
    var head = dummy;

    for (Integer v : source) {
      head.next = new ListNode(v);
      head = head.next;
    }

    return dummy.next;
  }

  @Override
  public String toString() {
    var sb = new StringBuffer();

    sb.append("[").append(val);

    if (next != null) {
      sb.append(" -> ");
    }

    var n = next;
    while (n != null) {
      sb.append(n.val);
      if (n.next != null) {
        sb.append(" -> ");
      }
      n = n.next;
    }

    sb.append("]");

    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListNode listNode = (ListNode) o;

    return this.toString().equals(listNode.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(val);
  }
}
