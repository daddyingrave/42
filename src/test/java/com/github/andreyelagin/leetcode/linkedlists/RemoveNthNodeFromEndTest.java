package com.github.andreyelagin.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndTest {

  RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
  
  @Test
  void removeNthFromEnd() {
    var node = new ListNode(123);
    removeNthNodeFromEnd.removeNthFromEnd(node, 1);
  }
}