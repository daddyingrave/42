package com.github.andreyelagin.leetcode.linkedlists;

public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;
    var cur = head;
    while (cur.next != null) {
      size++;
      cur = cur.next;
    }
    
    ListNode prev = null;
    cur = head;
    int limit = size - n;
    
    while (limit >= 0) {
      prev = cur;
      cur = cur.next;
      limit--;
    }
    
    if (prev == null) {
      return cur.next;
    }
    
    prev.next = cur.next;
    
    return head;
  }
}
