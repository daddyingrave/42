package com.github.andreyelagin.backtobackswe.linkedlists;

public class EvenOddPartition {
  public ListNode oddEvenList(ListNode head) {
    ListNode even = new ListNode(head.val);
    ListNode odd = new ListNode(head.next.val);
    var evenHead = even;
    var oddHead = odd;

    ListNode curr = head.next.next;
    boolean isEven = true;

    while (curr != null) {
      if (isEven) {
        even.next = new ListNode(curr.val);
        even = even.next;
        isEven = false;
      } else {
        odd.next = new ListNode(curr.val);
        odd = odd.next;
        isEven = true;
      }
      curr = curr.next;
    }

    even.next = oddHead;

    return evenHead;
  }
}
