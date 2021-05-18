package com.github.andreyelagin.backtobackswe.linkedlists;

import java.util.HashSet;

public class TestingForCycles {
  public boolean hasCycle(ListNode head) {
    var set = new HashSet<Integer>();
    
    var cur = head;
    while (cur != null) {
      if (!set.add(cur.val)) {
        return true;
      }
      cur = cur.next;
    }
    return false;
  }
}
