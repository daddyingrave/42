package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignLinkedList707Test {
  class MyLinkedList {
    Node SENTINEL_HEAD = new Node();
    Node SENTINEL_TAIL = new Node();

    Node tail;
    Node head;
    int size;

    public MyLinkedList() {
      head = SENTINEL_HEAD;
      tail = SENTINEL_TAIL;
      head.next = tail;
      tail.prev = head;
    }

    public int get(int index) {
      if (index >= size || index < 0) {
        return -1;
      }

      var cur = head;
      while (index >= 0) {
        cur = cur.next;
        index--;
      }

      return cur.val;
    }

    public void addAtHead(int val) {
      var curHead = head.next;
      var newHead = new Node();

      newHead.val = val;
      newHead.prev = head;
      newHead.next = curHead;

      head.next = newHead;
      curHead.prev = newHead;

      size++;
    }

    public void addAtTail(int val) {
      var curTail = tail.prev;
      var newTail = new Node();

      newTail.val = val;
      newTail.next = tail;
      newTail.prev = curTail;

      tail.prev = newTail;
      curTail.next = newTail;

      size++;
    }

    public void addAtIndex(int index, int val) {
      if (index > size || index < 0) {
        return;
      }

      var cur = head.next;
      while (index > 0) {
        cur = cur.next;
        index--;
      }
      var prev = cur.prev;

      var newNode = new Node();
      newNode.val = val;
      newNode.prev = prev;
      newNode.next = cur;

      prev.next = newNode;
      cur.prev = newNode;

      size++;
    }

    public void deleteAtIndex(int index) {
      if (size == 0 || index >= size || index < 0) {
        return;
      }

      var cur = head.next;
      while (index > 0) {
        cur = cur.next;
        index--;
      }
      var nodeToDelete = cur;
      nodeToDelete.prev.next = nodeToDelete.next;
      nodeToDelete.next.prev = nodeToDelete.prev;

      size--;
    }

    static class Node {
      int val;
      Node next;
      Node prev;
    }
  }

  @Test
  void test() {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
    assertEquals(2, myLinkedList.get(1));              // return 2
    myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
    assertEquals(3, myLinkedList.get(1));              // return 3
  }

}
