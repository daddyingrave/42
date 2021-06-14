package com.github.andreyelagin.backtobackswe.sorting;

import com.github.andreyelagin.backtobackswe.linkedlists.ListNode;

public class MergeSort {
  public ListNode mergeSort(ListNode head) {
    return split(head, null);
  }

  private ListNode split(ListNode node, ListNode rightLimit) {
    if (node == null || node.next == null) {
      return node;
    }
    
    var middle = middle(node, rightLimit);
    
    var leftSorted = split(node, middle);
    var rightSorted = split(middle.next, null);
    
    return merge(leftSorted, rightSorted);
  }

  private ListNode merge(ListNode left, ListNode right) {
    var dummy = new ListNode(666);
    var curLeft = left;
    var curRight = right;
    
    var ptr = dummy;
    while (curLeft != null || curRight != null) {
      if (curLeft != null && curRight != null) {
        if (curLeft.val > curRight.val) {
          ptr.next = curLeft;
          curLeft = curLeft.next;
        } else {
          ptr.next = curRight;
          curRight = curRight.next;
        }
        ptr = ptr.next;
      } else if (curLeft == null) {
        ptr.next = curRight;
        curRight = curRight.next;
        ptr = ptr.next;
      } else {
        ptr.next = curLeft;
        curLeft = curLeft.next;
        ptr = ptr.next;
      }
    }
    
    return dummy.next;
  }

  private ListNode middle(ListNode head, ListNode rightLimit) {
    int count = 0;
    var cur = head;
    while (cur != null && !cur.equals(rightLimit)) {
      count++;
      cur = cur.next;
    }
    
    cur = head;
    int iterations = count / 2;
    while (iterations > 0) {
      cur = cur.next;
      iterations--;
    }
    
    return cur;
  }
}
