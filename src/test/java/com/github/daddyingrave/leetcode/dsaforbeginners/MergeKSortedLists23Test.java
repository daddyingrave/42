package com.github.daddyingrave.leetcode.dsaforbeginners;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists23Test {
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  static class Pair {
    int key;
    ListNode value;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    var heap = new PriorityQueue<Pair>(Comparator.comparingInt(left -> left.key));

    for (ListNode list : lists) {
      if (list != null) {
        var p = new Pair();
        p.key = list.val;
        p.value = list;
        heap.add(p);
      }
    }

    var head = new ListNode();
    var cur = head;
    while (!heap.isEmpty()) {
      var top = heap.poll();
      cur.next = top.value;
      cur = cur.next;

      if (top.value.next != null) {
        var p = new Pair();
        p.key = top.value.next.val;
        p.value = top.value.next;
        heap.add(p);
      }
    }

    return head.next;
  }
}
