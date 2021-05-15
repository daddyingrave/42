package com.github.andreyelagin.backtobackswe.linkedlists;

public class RightShiftSinglyLinkedList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    
    var tail = head;
    int size = 1;
    while (tail.next != null) {
      tail = tail.next;
      size++;
    }
    
    k =  k % size;
    if (k == 0) {
      return head;
    }
    
    tail.next = head;
    
    int rotations = size - k;
    while (rotations > 0) {
      tail = tail.next;
      rotations--;
    }

    var newHead = tail.next;
    tail.next = null;

    return newHead;
  }
}
