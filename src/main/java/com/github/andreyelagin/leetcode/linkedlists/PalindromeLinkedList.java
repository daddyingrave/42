package com.github.andreyelagin.leetcode.linkedlists;

import java.util.Stack;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    int slow = 0;
    int quick = 0;
    var dummy = new ListNode();
    dummy.next = head;

    var slowPtr = dummy;
    var quickPtr = dummy;
    var dummyHead = dummy;

    var stack = new Stack<ListNode>();

    while (quickPtr.next != null) {
      if (quick / 2 >= slow) {
        slowPtr = slowPtr.next;
        stack.push(slowPtr);
        slow++;
      }
      
      quickPtr = quickPtr.next;
      quick++;
    }
    
    if (quick % 2 == 0) {
      slowPtr = slowPtr.next;
    }
    
    while (!stack.isEmpty()) {
      if (stack.pop().val != slowPtr.val) {
        return false;
      }
      slowPtr = slowPtr.next;
    }

    return true;
  }
}
