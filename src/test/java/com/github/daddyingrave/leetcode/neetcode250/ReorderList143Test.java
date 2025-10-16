package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

public class ReorderList143Test {
  class Solution {

    public void reorderList(ListNode head) {
      rec(head, head.next);
    }

    ListNode rec(ListNode root, ListNode cur) {
      if (cur == null) {
        return root;
      }

      root = rec(root, cur.next);
      if (root == null) {
        return null;
      }

      ListNode tmp = null;
      if (root == cur || root.next == cur) {
        cur.next = null;
      } else {
        tmp = root.next;
        root.next = cur;
        cur.next = tmp;
      }

      return tmp;
    }
  }

  @Test
  void test() {

  }
}
