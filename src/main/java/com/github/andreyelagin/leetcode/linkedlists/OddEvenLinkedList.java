package com.github.andreyelagin.leetcode.linkedlists;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode dummyOdd = new ListNode();
    ListNode dummyEven = new ListNode();
    var oddHead = dummyOdd;
    var evenHead = dummyEven;
    
    var cur = head;
    boolean odd = true;
    while (cur != null) {
      if (odd) {
        dummyOdd.next = cur;
        dummyOdd = dummyOdd.next;
        odd = false;
      } else {
        dummyEven.next = cur;
        dummyEven = dummyEven.next;
        odd = true;
      }
      cur = cur.next;
    }
    
    dummyEven.next = null;
    dummyOdd.next = evenHead.next;
    
    return oddHead.next;
  }
}
