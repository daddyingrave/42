package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignCircularQueue622Test {
  class MyCircularQueue {
    int maxSize;
    int size;
    Node front;
    Node rear;

    class Node {
      int val;
      Node next;

      public Node(int val) {
        this.val = val;
      }
    }

    public MyCircularQueue(int k) {
      maxSize = k;
    }

    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }

      var newNode = new Node(value);
      if (rear == null) {
        front = newNode;
        rear = newNode;
        front.next = rear;
      } else {
        rear.next = newNode;
        newNode.next = front;
        rear = newNode;
      }

      size++;

      return true;
    }

    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }

      if (size == 1) {
        front = null;
        rear = null;
      } else {
        front = front.next;
        rear.next = front;
      }

      size--;

      return true;
    }

    public int Front() {
      if (front == null) {
        return -1;
      }

      return front.val;
    }

    public int Rear() {
      if (rear == null) {
        return -1;
      }

      return rear.val;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean isFull() {
      return size == maxSize;
    }
  }

  @Test
  void test() {
    MyCircularQueue myCircularQueue = new MyCircularQueue(3);
    assertTrue(myCircularQueue.enQueue(1)); // return True
    assertTrue(myCircularQueue.enQueue(2)); // return True
    assertTrue(myCircularQueue.enQueue(3)); // return True
    assertFalse(myCircularQueue.enQueue(4)); // return False
    assertEquals(3, myCircularQueue.Rear());     // return 3
    assertTrue(myCircularQueue.isFull());   // return True
    assertTrue(myCircularQueue.deQueue());  // return True
    assertTrue(myCircularQueue.enQueue(4));; // return True
    assertEquals(4, myCircularQueue.Rear());     // return 4
  }
}
