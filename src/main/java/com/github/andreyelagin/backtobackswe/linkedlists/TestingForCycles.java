package com.github.andreyelagin.backtobackswe.linkedlists;

import java.util.HashSet;

public class TestingForCycles {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    
    var slow = head;
    var fast = head;
    while (fast != null) {
      var curSlow = slow.next;
      var curFast = fast.next == null ? null : fast.next.next;
      if (curFast != null && curFast.val == curSlow.val) {
        return true;
      }
      slow = curSlow;
      fast = curFast;
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
