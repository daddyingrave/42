package com.github.andreyelagin.backtobackswe.linkedlists;

import java.util.Objects;

// https://backtobackswe.com/platform/content/design-a-linked-list
public class CustomLinkedList {
  private ListNode head;
  private int size;

  public CustomLinkedList() {
  }

  public CustomLinkedList(ListNode node) {
    int count = 0;
    var cur = node;
    while (cur != null) {
      cur = cur.next;
      count++;
    }
    size = count;
    head = node;
  }

  public CustomLinkedList(int value) {
    this.head = new ListNode(value);
  }

  public int get(int index) {
    if (index >= size) {
      return -1;
    }

    var cur = head;
    while (index > 0) {
      cur = cur.next;
      index--;
    }

    return cur.val;
  }

  public void addAtHead(int value) {
    var newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
    size++;
  }

  public void addAtTail(int value) {
    int count = size;
    var cur = head;

    while (count > 1) {
      cur = cur.next;
      count--;
    }
    
    if (cur == null) {
      head = new ListNode(value);
    } else {
      cur.next = new ListNode(value);
    }

    size++;
  }

  public void addAtIndex(int index, int value) {
    if (index >= size) {
      return;
    }

    var cur = head;
    while (index > 0) {
      cur = cur.next;
      index--;
    }

    var oldNext = cur.next;
    cur.next = new ListNode(value);
    cur.next.next = oldNext;
    
    size++;
  }

  public void deleteAtIndex(int index) {
    if (index >= size) {
      return;
    }

    var cur = head;
    while (index > 1) {
      cur = cur.next;
      index--;
    }

    cur.next = cur.next.next;
    
    size--;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomLinkedList that = (CustomLinkedList) o;
    if (size != that.size) {
      return false;
    }

    return head.equals(((CustomLinkedList) o).head);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size);
  }

  @Override
  public String toString() {
    return head.toString();
  }
}
