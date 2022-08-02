package com.github.daddyingrave.leetcode.linkedlists;

public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    
    ListNode prev = null;
    ListNode distant = dummy;
    ListNode cur = dummy;
    int distance = 0;
    
    while (cur.next != null) {
      var curTemp = cur;
      cur = cur.next;
      distance++;
      if (distance >= n) {
        prev = distant;
        distant = distant.next;
        distance--;
      }
    }
    
    if (prev != null) {
      prev.next = distant.next;
    }
    
    return dummy.next;
  }
  
  public ListNode removeNthFromEnd2(ListNode head, int n) {
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
