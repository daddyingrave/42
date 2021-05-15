package com.github.andreyelagin.backtobackswe.linkedlists;

import java.util.Objects;

// https://backtobackswe.com/platform/content/design-a-linked-list
public class CustomLinkedList {
  private ListNode head;
  private int size;

  public CustomLinkedList() {
    this.head = new ListNode(Integer.MIN_VALUE);
  }

  public CustomLinkedList(ListNode node) {
    this.head = new ListNode(Integer.MIN_VALUE);

    int count = 0;
    var cur = node;
    while (cur != null) {
      cur = cur.next;
      count++;
    }
    size = count;
    this.head.next = node;
  }

  public CustomLinkedList(int value) {
    head = new ListNode(Integer.MIN_VALUE);
    this.head = new ListNode(value);
  }

  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1;
    }

    var cur = head.next;
    while (index > 0) {
      cur = cur.next;
      index--;
    }

    return cur.val;
  }

  public void addAtHead(int value) {
    var newNode = new ListNode(value);
    newNode.next = head.next;
    head.next = newNode;
    size++;
  }

  public void addAtTail(int value) {
    var cur = head;
    while (cur.next != null) {
      cur = cur.next;
    }

    cur.next = new ListNode(value);
    size++;
  }

  public void addAtIndex(int index, int value) {
    if (index < 0 || index >= size) {
      return;
    }

    var cur = head;
    while (index > 0) {
      cur = cur.next;
      index--;
    }

    ListNode newNode = new ListNode(value);
    newNode.next = cur.next;
    cur.next = newNode;

    size++;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }

    var cur = head;
    while (index > 0) {
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

    return head.next.equals(that.head.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size);
  }

  @Override
  public String toString() {
    return head.next.toString();
  }
}
