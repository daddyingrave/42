package com.github.daddyingrave.leetcode.linkedlists;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    var dummy = new ListNode();
    var head = dummy;
    
    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = 0;
      
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      if (carry > 0) {
        sum += carry;
        carry = 0;
      }
      if (sum >= 10) {
        sum = sum % 10;
        carry = 1;
      }
      
      head.next = new ListNode(sum);  
      head = head.next;
    }
    
    if (carry > 0) {
      head.next = new ListNode(carry);
    }
    
    return dummy.next;
  }
}
