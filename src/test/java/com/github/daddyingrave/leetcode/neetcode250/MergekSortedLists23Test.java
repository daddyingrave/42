package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class MergekSortedLists23Test {
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }

      while (lists.length > 1) {
        var merged = new ArrayList<ListNode>();
        for (int i = 0; i < lists.length; i += 2) {
          var left = lists[i];
          var right = i + 1 >= lists.length ? null : lists[i + 1];

          merged.add(merge(left, right));
        }
        lists = merged.toArray(new ListNode[0]);
      }

      return lists[0];
    }

    ListNode merge(ListNode left, ListNode right) {
      var dummy = new ListNode();
      var cur = dummy;
      while (left != null && right != null) {
        if (left.val < right.val) {
          cur.next = left;
          cur = left;
          left = left.next;
        } else {
          cur.next = right;
          cur = right;
          right = right.next;
        }
      }

      while (left != null) {
        cur.next = left;
        cur = left;
        left = left.next;
      }

      while (right != null) {
        cur.next = right;
        cur = right;
        right = right.next;
      }

      cur.next = null;

      return dummy.next;
    }
  }

  @Test
  void test() {

  }
}
