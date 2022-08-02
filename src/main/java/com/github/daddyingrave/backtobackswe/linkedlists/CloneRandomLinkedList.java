package com.github.daddyingrave.backtobackswe.linkedlists;

import java.util.HashMap;

public class CloneRandomLinkedList {
  public RandomListNode copyRandomList(RandomListNode head) {
    var cur = head;
    while (cur != null) {
      var newNode = new RandomListNode(cur.val);
      newNode.next = cur.next;
      cur.next = newNode;
      cur = newNode.next;
    }

    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }

    cur = head;
    var newHead = head.next;
    while (cur != null) {
      var next = cur.next.next;
      if (cur.next.next != null) {
        cur.next.next = cur.next.next.next;
      }
      cur = next;
    }

    return newHead;
  }

  public RandomListNode copyRandomListHashMap(RandomListNode head) {
    var copyMap = new HashMap<Integer, RandomListNode>();

    var cur = head;
    while (cur != null) {
      copyMap.put(cur.val, new RandomListNode(cur.val));
      cur = cur.next;
    }

    cur = head;
    while (cur != null) {
      var newNode = copyMap.get(cur.val);
      var next = cur.next == null ? null : cur.next.val;
      var nextRandom = cur.random == null ? null : cur.random.val;
      newNode.next = copyMap.get(next);
      newNode.random = copyMap.get(nextRandom);
      cur = cur.next;
    }

    return copyMap.get(head.val);
  }
}
