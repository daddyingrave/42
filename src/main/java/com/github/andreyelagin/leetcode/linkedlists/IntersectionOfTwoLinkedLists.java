package com.github.andreyelagin.leetcode.linkedlists;

public class IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    
    var curA = headA;
    while (curA.next != null) {
      curA = curA.next;
    }
    
    curA.next = headA;
    
    var quick = headB;
    var slow = headB;
    
    while (quick != null && quick.next != null) {
      slow = slow.next;
      quick = quick.next.next;
      if (slow == quick) {
        break;
      }
    }
    
    if (quick == null || quick.next == null) {
      curA.next = null;
      return null;
    }
    
    slow = headB;
    
    while (slow != quick) {
      slow = slow.next;
      quick = quick.next;
    }
    
    curA.next = null;
    return slow;
  }
}
