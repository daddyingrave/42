package com.github.andreyelagin.leetcode.linkedlists;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    var odd = head;
    var even = head.next;
    var evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }

    odd.next = evenHead;

    return head;
  }
}
