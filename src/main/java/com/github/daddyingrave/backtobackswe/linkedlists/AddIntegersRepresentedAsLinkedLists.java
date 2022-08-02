package com.github.daddyingrave.backtobackswe.linkedlists;

public class AddIntegersRepresentedAsLinkedLists {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    var accumulator = new ListNode(666);
    var accIterator = accumulator;

    var left = l1;
    var right = l2;
    int carry = 0;

    while (left != null || right != null) {
      int sum = carry;
      if (left != null) {
        sum += left.val;
        left = left.next;
      }
      if (right != null) {
        sum += right.val;
        right = right.next;
      }
      if (sum >= 10) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }
      accIterator.next = new ListNode(sum);
      accIterator = accIterator.next;
    }
    
    if (carry > 0) {
      accIterator.next = new ListNode(1);  
    }

    return accumulator.next;
  }
}
