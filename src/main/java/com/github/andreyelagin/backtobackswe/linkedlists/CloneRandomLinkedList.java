package com.github.andreyelagin.backtobackswe.linkedlists;

import java.util.HashMap;

public class CloneRandomLinkedList {
  public RandomListNode copyRandomList(RandomListNode head) {
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
