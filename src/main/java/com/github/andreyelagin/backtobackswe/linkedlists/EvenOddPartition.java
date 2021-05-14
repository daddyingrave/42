package com.github.andreyelagin.backtobackswe.linkedlists;

public class EvenOddPartition {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    var even = head;
    var odd = head.next;

    var oddHead = odd;

    while (even.next != null && odd.next != null) {
      even.next = odd.next;
      even = odd.next;
      odd.next = even.next;
      odd = even.next;
    }

    even.next = oddHead;

    return head;
  }

  public ListNode oddEvenListMy(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
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
