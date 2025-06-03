package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

public class ReverseLinkedList206Test {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    var prev = head;
    var last = head;
    while (last != null) {
      prev = last;
      last = last.next;
    }

    traverse(null, head);

    return prev;
  }

  void traverse(ListNode prev, ListNode head) {
    if (head == null) {
      return;
    }

    var next = head.next;
    head.next = prev;
    traverse(head, next);
  }

  @Test
  void test() {
    var node5 = new ListNode(5, null);
    var node4 = new ListNode(4, node5);
    var node3 = new ListNode(3, node4);
    var node2 = new ListNode(2, node3);
    var node1 = new ListNode(1, node2);

    ListNode listNode = reverseList(node1);
    System.out.println("123");
  }
}
