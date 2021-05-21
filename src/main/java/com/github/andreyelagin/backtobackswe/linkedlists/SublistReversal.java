package com.github.andreyelagin.backtobackswe.linkedlists;

public class SublistReversal {
  public ListNode reverseBetween(ListNode head, int start, int end) {
    ListNode prevSub = null;
    ListNode nextSub = null;
    int index = 1;

    ListNode dummy = new ListNode(666);
    dummy.next = head;
    
    ListNode cur = head;
    ListNode prev = dummy;
    while (cur != null) {
      if (index == start) {
        prevSub = prev;
      }
      if (index == end) {
        nextSub = cur.next;
      }

      prev = cur;
      cur = cur.next;
      
      index++;
    }
    
    index = start;
    cur = prevSub.next;
    prev = null;
    ListNode subHead = null;
    ListNode subTail = null;
    while (index <= end) {
      if (index == start) {
        subTail = cur;
      }
      if (index == end) {
        subHead = cur;
      }
      
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
      
      index++;
    }
    prevSub.next = subHead;
    subTail.next = nextSub;
    
    return dummy.next;
  }
}
