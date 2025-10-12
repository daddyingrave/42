package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedLists21Test {
  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      var head = new ListNode();
      var cur = head;

      while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
          cur.next = list1;
          list1 = list1.next;
        } else {
          cur.next = list2;
          list2 = list2.next;
        }

        cur = cur.next;
      }

      while (list1 != null) {
        cur.next = list1;
        cur = cur.next;
        list1 = list1.next;
      }
      while (list2 != null) {
        cur.next = list2;
        cur = cur.next;
        list2 = list2.next;
      }

      return head.next;
    }
  }

  @Test
  void test() {

  }
}
