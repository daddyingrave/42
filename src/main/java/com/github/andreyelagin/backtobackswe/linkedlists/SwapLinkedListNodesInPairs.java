package com.github.andreyelagin.backtobackswe.linkedlists;

public class SwapLinkedListNodesInPairs {
  public ListNode swapInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    var left = head;
    var right = head.next;
    ListNode nextSegment = null;
    
    head = head.next;
    
    while (true) {
      nextSegment = right.next;
      right.next = left;
      
      if (nextSegment == null || nextSegment.next == null) {
        left.next = nextSegment;
        return head;
      }
      
      left.next = nextSegment.next;
      
      left = nextSegment;
      right = nextSegment.next;
    }
  }
}
