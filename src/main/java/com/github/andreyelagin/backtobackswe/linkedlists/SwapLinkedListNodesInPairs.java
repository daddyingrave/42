package com.github.andreyelagin.backtobackswe.linkedlists;

public class SwapLinkedListNodesInPairs {
  public ListNode swapInPairs(ListNode head) {
    var dummy = new ListNode(666);
    var left = head;
    var right = head == null ? null : head.next;
    
    if (right == null) {
      dummy.next = head;
    } else {
      dummy.next = right;
    }
    
    ListNode prevRight = null;
    while (left != null && right != null) {
      var next = right.next;
      right.next = null;
      left.next = null;
      right.next = left;
      
      if (prevRight != null) {
        prevRight.next = right;
      }
      prevRight = left;
      
      left = next;
      right = next == null ? null : next.next;
    }
    
    if (left != null && prevRight != null) {
      prevRight.next = left;
    }

    return dummy.next;
  }
}
