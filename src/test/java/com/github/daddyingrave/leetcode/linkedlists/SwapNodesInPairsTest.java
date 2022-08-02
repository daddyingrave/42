package com.github.daddyingrave.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SwapNodesInPairsTest {

  SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

  @Test
  void swapPairs() {
    ListNode head = ListNode.fromList(List.of(1, 2, 3, 4));

    var expected = ListNode.fromList(List.of(2, 1, 4, 3));

    assertEquals(expected, swapNodesInPairs.swapPairs(head));
  }
}