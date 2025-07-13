package com.github.daddyingrave.leetcode.dsaforbeginners;

public class MergeKSortedLists23RecTest {
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
    if (lists.length == 0) {
      return null;
    } else if (lists.length == 1) {
      return lists[0];
    }

    return divide(lists, 0, lists.length - 1);
  }

  // list 1: 1, 2, 3
  // list 2: 4, 5, 6
  // list 3: 7, 8, 9
  //
  // 1 - 0, 1
  // 2 - 0, 0
  // 2 - 2, 0
  // 1 - 2, 2
  ListNode divide(ListNode[] lists, int left, int right) {
    if (left > right) {
      return null;
    } else if (left == right) {
      return lists[left];
    }

    int mid = left + (right - left) / 2;
    var leftList = divide(lists, left, mid);
    var rightList = divide(lists, mid + 1, right);

    return conquer(leftList, rightList);
  }

  ListNode conquer(ListNode left, ListNode right) {
    var newNode = new ListNode();
    var cur = newNode;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }

      cur = cur.next;
    }

    while (left != null) {
      cur.next = left;
      left = left.next;
      cur = cur.next;
    }
    while (right != null) {
      cur.next = right;
      right = right.next;
      cur = cur.next;
    }

    return newNode.next;
  }
}
