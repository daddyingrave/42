package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.ListNode;
import org.junit.jupiter.api.Test;

public class AddTwoNumbers2Test {
  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      var dummy = new ListNode();
      var cur = dummy;

      int carry = 0;
      while (l1 != null || l2 != null) {
        int left = l1 != null ? l1.val : 0;
        int right = l2 != null ? l2.val : 0;

        int sum = left + right + carry;
        if (sum > 9) {
          carry = 1;
          sum = sum % 10;
        } else {
          carry = 0;
        }

        cur.next = new ListNode(sum);
        cur = cur.next;

        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
      }

      if (carry != 0) {
        cur.next = new ListNode(carry);
      }

      return dummy.next;
    }
  }

  @Test
  void test() {

  }
}
