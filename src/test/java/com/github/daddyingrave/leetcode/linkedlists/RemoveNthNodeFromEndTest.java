package com.github.daddyingrave.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndTest {

  RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
  
  @Test
  void removeNthFromEnd() {
    var node = new ListNode(123);
    removeNthNodeFromEnd.removeNthFromEnd(node, 1);
  }
}