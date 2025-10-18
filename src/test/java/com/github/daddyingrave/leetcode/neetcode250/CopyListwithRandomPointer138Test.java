package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyListwithRandomPointer138Test {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  class Solution {
    public Node copyRandomList(Node head) {
      var map = new HashMap<Node, Node>();
      var dummy = new Node(0);
      var newCur = dummy;
      var cur = head;

      while (cur != null) {
        var newNode = new Node(cur.val);
        map.put(cur, newNode);
        newCur.next = newNode;
        newCur = newNode;
        cur = cur.next;
      }

      cur = head;
      newCur = dummy.next;
      while (cur != null) {
        if (cur.random != null) {
          newCur.random = map.get(cur.random);
        }
        cur = cur.next;
        newCur = newCur.next;
      }

      return dummy.next;
    }
  }

  @Test
  void test() {

  }
}
