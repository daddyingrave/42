package com.github.andreyelagin.leetcode.linkedlists;

public class DeleteNodeInLinkedList {
  public void deleteNode(ListNode node) {
    if (node == null) {
      return;
    }

    ListNode prev = null;
    ListNode cur = node;
    
    while (cur.next != null) {
      prev = cur;
      cur.val = cur.next.val;
      cur = cur.next;
    }
    
    prev.next = null;
  }
}
