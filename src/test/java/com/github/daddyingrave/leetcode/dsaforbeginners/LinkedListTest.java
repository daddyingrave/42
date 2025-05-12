package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
  class LinkedList {
    private final Node SENTINEL_TAIL = new Node();

    Node head;
    Node tail;
    int size;

    public LinkedList() {
      tail = SENTINEL_TAIL;
    }

    public int get(int index) {
      if (index > size - 1) {
        return - 1;
      }
      index = size - index - 1;
      var cur = tail;
      while (index >= 0 && cur != null) {
        cur = cur.next;
        index--;
      }
      if (cur == null) {
        return -1;
      }

      return cur.val;
    }

    public void insertHead(int val) {
      var node = new Node();
      node.val = val;
      if (head == null) {
        tail.next = node;
      } else {
        head.next = node;
      }

      head = node;
      size++;
    }

    public void insertTail(int val) {
      var node = new Node();
      node.val = val;
      if (tail.next == null) {
        tail.next = node;
        head = node;
      } else {
        var tmp = tail.next;
        tail.next = node;
        node.next = tmp;
      }
      size++;
    }

    public boolean remove(int index) {
      if (index > size - 1) {
        return false;
      }
      index = size - index - 1;

      var cur = tail;
      Node prev = null;
      while (index >= 0 && cur != null) {
        prev = cur;
        cur = cur.next;
        index--;
      }

      size--;
      if (cur == null) {
        return false;
      } else {
        if (head == cur) {
          head = prev;
        }

        prev.next = cur.next;
        return true;
      }
    }

    public ArrayList<Integer> getValues() {
      var result = new ArrayList<Integer>();
      var cur = tail.next;
      while (cur != null) {
        result.add(0, cur.val);
        cur = cur.next;
      }

      return result;
    }

    static class Node {
      int val;
      Node next;
    }
  }

  @Test
  void test() {
    var ll = new LinkedList();
    assertEquals(-1, ll.get(1));
    assertEquals(-1, ll.get(2));
    assertEquals(-1, ll.get(3));
    assertEquals(List.of(), ll.getValues());

    ll.insertHead(1);
    assertEquals(1, ll.get(0));
    assertEquals(-1, ll.get(1));
    assertEquals(-1, ll.get(2));
    assertEquals(List.of(1), ll.getValues());

    ll.insertTail(2);
    assertEquals(2, ll.get(0));
    assertEquals(1, ll.get(1));
    assertEquals(-1, ll.get(2));
    assertEquals(List.of(2, 1), ll.getValues());

    ll.insertHead(3);
    assertEquals(2, ll.get(0));
    assertEquals(1, ll.get(1));
    assertEquals(3, ll.get(2));
    assertEquals(List.of(2, 1, 3), ll.getValues());

    ll.remove(2);
    assertEquals(2, ll.get(0));
    assertEquals(1, ll.get(1));
    assertEquals(-1, ll.get(2));
    assertEquals(List.of(2, 1), ll.getValues());

    ll.insertHead(3);

    ll.remove(1);
    assertEquals(2, ll.get(0));
    assertEquals(3, ll.get(1));
    assertEquals(-1, ll.get(2));
    assertEquals(List.of(2, 3), ll.getValues());
  }

    @Test
  void test2() {
    var ll = new LinkedList();
    ll.insertHead(1); // 1
    ll.insertTail(2); // 2 1
    ll.insertHead(0); // 2 1 0
    ll.remove(1);
    assertEquals(List.of(0, 2), ll.getValues());
  }
}
