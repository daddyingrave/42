package com.github.daddyingrave.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

class OddEvenLinkedListTest {

  OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
  
  @Test
  void oddEvenList() {
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(3);
    var node4 = new ListNode(4);
    var node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    oddEvenLinkedList.oddEvenList(node1);
  }
}