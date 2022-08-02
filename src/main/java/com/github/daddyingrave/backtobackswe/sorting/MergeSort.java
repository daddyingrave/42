package com.github.daddyingrave.backtobackswe.sorting;

import com.github.daddyingrave.backtobackswe.linkedlists.ListNode;

public class MergeSort {
  public ListNode mergeSort(ListNode head) {
    return split(head);
  }

  private ListNode split(ListNode node) {
    if (node == null || node.next == null) {
      return node;
    }
    
    var middle = middle(node);
    
    var leftSorted = split(node);
    var rightSorted = split(middle);
    
    return merge(leftSorted, rightSorted);
  }

  private ListNode merge(ListNode left, ListNode right) {
    var dummy = new ListNode(666);
    var curLeft = left;
    var curRight = right;
    
    var ptr = dummy;
    while (curLeft != null || curRight != null) {
      if (curLeft != null && curRight != null) {
        if (curLeft.val < curRight.val) {
          ptr.next = curLeft;
          curLeft = curLeft.next;
        } else {
          ptr.next = curRight;
          curRight = curRight.next;
        }
      } else if (curLeft == null) {
        ptr.next = curRight;
        curRight = curRight.next;
      } else {
        ptr.next = curLeft;
        curLeft = curLeft.next;
      }
      ptr = ptr.next;
    }
    
    return dummy.next;
  }

  private ListNode middle(ListNode head) {
    int count = 0;
    var cur = head;
    while (cur != null) {
      count++;
      cur = cur.next;
    }
    
    cur = head;
    ListNode prev = null;
    int iterations = count / 2;
    while (iterations > 0) {
      prev = cur;
      cur = cur.next;
      iterations--;
    }
    if (prev != null) {
      prev.next = null;
    }
    return cur;
  }
}
