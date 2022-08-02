package com.github.daddyingrave.backtobackswe.linkedlists;

import java.util.HashSet;

public class TestingForCycles {
  public boolean hasCycle(ListNode head) {
    var slow = head;
    var fast = head;
    
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast != null && fast.val == slow.val) {
        return true;
      }
    }
    
    return false;
  }

  public boolean hasCycleNaive(ListNode head) {
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
