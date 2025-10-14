package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListCycle141Test {
  public class Solution {
    public boolean hasCycle(ListNode head) {
      var slow = head;
      var fast = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
          return true;
        }
      }

      return false;
    }
  }

  @Test
  void test() {

  }
}
