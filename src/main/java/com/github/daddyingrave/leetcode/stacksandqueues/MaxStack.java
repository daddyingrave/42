package com.github.daddyingrave.leetcode.stacksandqueues;

import com.github.daddyingrave.leetcode.linkedlists.DoublyLinkedNode;

import java.util.*;

public class MaxStack {
  private final TreeMap<Integer, List<DoublyLinkedNode>> stack = new TreeMap<>();
  private DoublyLinkedNode last = new DoublyLinkedNode(0);
  private int size;

  public MaxStack() {
  }

  public void push(int x) {
    var node = new DoublyLinkedNode(x);
    last.next = node;
    node.prev = last;
    last = node;
    stack.compute(x, (key, value) -> {
      if (value == null) {
        var list = new ArrayList<DoublyLinkedNode>();
        list.add(node);
        return list;
      } else {
        value.add(node);
        return value;
      }
    });
    size++;
  }

  public int pop() {
    var list = stack.remove(last.val);
    var node = list.remove(list.size() - 1);
    if (list.size() > 0) {
      stack.put(last.val, list);
    }
    int val = last.val;
    last = last.prev;
    last.next = null;
    size--;
    return val;
  }

  public int top() {
    return last.val;
  }

  public int peekMax() {
    return stack.lastKey();
  }

  public int popMax() {
    int last = stack.lastKey();
    var list = stack.remove(last);
    var node = list.remove(list.size() - 1);

    if (node.next == null) {
      this.last = node.prev;
      this.last.next = null;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    if (list.size() > 0) {
      stack.put(last, list);
    }

    size--;
    return last;
  }
}
